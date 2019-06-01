pipeline {
    agent {
        //指定此Pipeline将在动态Jenkins Slave中执行
        label "aliyun-jenkins-slave-java"
    }
    options {
        //仅保留最近10次的构建记录
        buildDiscarder(logRotator(numToKeepStr: '10'))
        //设置管道运行的超时时间，在此之后，Jenkins将中止管道
        timeout(time: 20, unit: 'MINUTES')
        //失败重试次数
        //retry(2)
        //输出时间戳
        timestamps()
    }
    environment {

       //应用名称参数
       APP_NAME = "${APP_NAME}"
       //edas 应用对应的ID
       EDAS_APPID = "${EDAS_APPID}"
       //应用版本号
       APP_VERSION = "${APP_VERSION}"
       //K8S环境参数
       K8S_ENV = "${ALIYUN_ENV}"

       //获取Docker Registry的凭据信息
       DOCKERREG_ACCESS_KEY = credentials('docker-registry-credentials')
       //定义镜像的Tag(即版本号由VersionNumber插件动态生成)
       //格式：<用于build的源码分支>-<build的所属年月日>-<当天的第N次build>
       IMAGE_TAG = VersionNumber(projectStartDate: '1970-01-01', versionNumberString: '${BUILD_DATE_FORMATTED, "yyyyMMdd"}-${BUILDS_TODAY, XXX}', versionPrefix: "${ALIYUN_ENV}-")
       //私有镜像中心的地址
       DOCKERREG_DOMAIN = "${DOCKERREG_DOMAIN}"
       //私有镜像中心镜像所在的ns
       TARGET_NAMESPACE = "${TARGET_NAMESPACE}"
       //应用镜像的完整构成
       APP_DOCKER_IMAGE ="${DOCKERREG_DOMAIN}/${TARGET_NAMESPACE}/${APP_NAME}:${IMAGE_TAG}"

       //JOB所在根目录
       WORKSPACE_PATH = "${GLOBAL_WORKSPACE_PATH}/${env.JOB_NAME}/"
       //启动类所在module名称
       MODULE_NAME = "${MODULE_NAME}"

       //SonarQube平台的凭据信息
       SONAR_QUBE_ACCESS_KEY = credentials('SONAR_QUBE_ADDR_TOKEN')
    }
    stages {
        stage('Replace Environment Variables!'){
            steps {
                dir("${WORKSPACE_PATH}") {
                   sh "sed -i 's/APP_SQL_URI/${APP_SQL_URI}/g'  `find . -name application-dynamic.*`"
                   sh "sed -i 's/APP_SQL_ACCOUNT/${APP_SQL_ACCOUNT}/g'  `find . -name application-dynamic.*`"
                   sh "sed -i 's/APP_SQL_PASSWORD/${APP_SQL_PASSWORD}/g'  `find . -name application-dynamic.*`"

                   sh "sed -i 's/SLAVE_APP_SQL_URI/${SLAVE_APP_SQL_URI}/g'  `find . -name application-dynamic.*`"
                   sh "sed -i 's/SLAVE_APP_SQL_ACCOUNT/${SLAVE_APP_SQL_ACCOUNT}/g'  `find . -name application-dynamic.*`"
                   sh "sed -i 's/SLAVE_APP_SQL_PASSWORD/${SLAVE_APP_SQL_PASSWORD}/g'  `find . -name application-dynamic.*`"

                   sh "sed -i 's/APP_REDIS_IP/${APP_REDIS_IP}/g'  `find . -name application-dynamic.*`"
                   sh "sed -i 's/APP_REDIS_PORT/${APP_REDIS_PORT}/g'  `find . -name application-dynamic.*`"
                   sh "sed -i 's/APP_REDIS_PASSWORD/${APP_REDIS_PASSWORD}/g'  `find . -name application-dynamic.*`"


                    //SPRING_PROFILES_ACTIVE替换为实际的${PROFILES_ACTIVE} Maven编译环境
                    sh "sed -i 's/SPRING_PROFILES_ACTIVE/dynamic/g' Dockerfile"
                    //替换应用名称+版本号
                    sh "sed -i 's/APP_NAME_VERSION/${APP_NAME}-${APP_VERSION}/g' Dockerfile"
                    //替换应用的service层模块的名称，此名称要与应用的名称一致
                    sh "sed -i 's/SERVICE_MODULE_NAME/${MODULE_NAME}/g' Dockerfile"
                }
            }
        }
        stage('Mvn Clean Compile Package Deploy!') {
			steps {
                dir("${WORKSPACE_PATH}") {
                    //代码 clean 和 compile,为代码检查等其他maven操作做准备
                    sh 'mvn clean compile'
                    //mvn package
                    sh "mvn -U package -Dmaven.test.skip"
                    //mvn deploy
                    //sh "mvn -U deploy"
                }
            }
        }
        stage('Parallel Stage') {
            parallel {
                stage('App\'s Code Sonar!') {
                    when {
                        //dev、test环境执行sonar检测
                        expression { K8S_ENV ==~ /(dev|test)/ }
                    }
                    steps {
                        dir("${WORKSPACE_PATH}") {
                            //安装代码覆盖率插件
                            //sh 'mvn org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true'
                            //发布到SonarQube平台
                            //sh 'mvn sonar:sonar -Dsonar.host.url=${SONAR_QUBE_ACCESS_KEY_USR} -Dsonar.login=${SONAR_QUBE_ACCESS_KEY_PSW} -T1C'
                        }
                    }
                }

                stage('Build App Image') {
                    steps {
                       dir("${WORKSPACE_PATH}") {
                            //以项目根目录为构建上下文 根据Dockerfile构建应用镜像
                            sh "docker build --no-cache -t ${APP_DOCKER_IMAGE} ."
                            //先登录到阿里云的Docker Registry
                            sh "docker login -u ${DOCKERREG_ACCESS_KEY_USR} -p ${DOCKERREG_ACCESS_KEY_PSW} https://${DOCKERREG_DOMAIN}"
                            //将所构建的镜像推送到阿里云的Docker Registry
                            sh "docker push ${APP_DOCKER_IMAGE}"
                            // 删除WORK节点上保留的应用镜像
                            sh "docker rmi ${APP_DOCKER_IMAGE}"
                       }
                    }
                }
            }
        }

        stage('Deploy App Image') {
            steps {
               dir("${WORKSPACE_PATH}") {
                  //CLI部署edas应用到集群
                  sh "aliyun edas POST /pop/v5/k8s/acs/k8s_apps --AppId ${EDAS_APPID} --Image ${APP_DOCKER_IMAGE} > /opt/发送部署结果: 2>&1"
                  //查看响应信息
                  sh "cat /opt/发送部署结果:"
                  //查看部署历史
                  sh "aliyun edas POST /pop/v5/changeorder/change_order_info --ChangeOrderId `sed -n 's/.*\"ChangeOrderId\": \"\\([a-z0-9-]*\\).*/\\1/p' /opt/发送部署结果:`"
               }
            }
        }
    }
    post {
        success {
            emailext (
                subject: "'${env.JOB_NAME} [${env.BUILD_NUMBER}]' 构建正常",
                body: """
                详情：<br/><hr/>
                &nbsp;&nbsp;<span style='color:green'>SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'</span><br/><hr/>
                &nbsp;&nbsp;项目名称：$JOB_NAME<br/><hr/>
                &nbsp;&nbsp;构建编号：$BUILD_NUMBER<br/><hr/>
                &nbsp;&nbsp;构建日志地址：<a href="${BUILD_URL}console">${BUILD_URL}console</a><br/><hr/>
                &nbsp;&nbsp;构建地址：<a href="$BUILD_URL">$BUILD_URL</a><br/><hr/>
                &nbsp;&nbsp;<b>本邮件是程序自动下发的，请勿回复！</b><br/><hr/>
                """,
                to: "${DEFAULT_RECIPIENTS}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']]
             )
        }
        failure {
            emailext (
                subject: "'${env.JOB_NAME} [${env.BUILD_NUMBER}]' 构建失败",
                body: """
                详情：<br/><hr/>
                &nbsp;&nbsp;<span style='color:red'>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'</span><br/><hr/>
                &nbsp;&nbsp;项目名称：$JOB_NAME<br/><hr/>
                &nbsp;&nbsp;构建编号：$BUILD_NUMBER<br/><hr/>
                &nbsp;&nbsp;构建日志地址：<a href="${BUILD_URL}console">${BUILD_URL}console</a><br/><hr/>
                &nbsp;&nbsp;构建地址：<a href="$BUILD_URL">$BUILD_URL</a><br/><hr/>
                &nbsp;&nbsp;<b>本邮件是程序自动下发的，请勿回复！</b><br/><hr/>
                """,
                to: "${DEFAULT_RECIPIENTS}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']]
             )
        }
    }
}
