FROM centos:7
LABEL maintainer="zhou.yanli@iwhalecloud.com"

# 安装打包必备软件
RUN yum -y install wget unzip
# 准备 JDK/Tomcat 系统变量与路径
ENV JAVA_HOME /usr/java/latest
ENV CATALINA_HOME /home/admin/taobao-tomcat
ENV PATH $PATH:$JAVA_HOME/bin
# 设置 EDAS-Container / Pandora 应用容器版本
ENV EDAS_CONTAINER_VERSION V3.5.0
LABEL pandora V3.5.0
# 设置 EDAS 应用 JVM 参数
ENV CATALINA_OPTS ${EDAS_CATALINA_OPTS}
# 设置 JVM 参数
ENV JAVA_OPTS="-Dalicloud.deployment.mode=EDAS_MANAGED"
# 下载安装 JDK 8
RUN wget http://edas-hz.oss-cn-hangzhou.aliyuncs.com/agent/prod/files/jdk-8u191-linux-x64.rpm -O /tmp/jdk-8u191-linux-x64.rpm && \
  yum -y install /tmp/jdk-8u191-linux-x64.rpm && \
  rm -rf /tmp/jdk-8u191-linux-x64.rpm
# 根据环境变量，下载安装 EDAS Contaienr / Pandora 应用容器版本
RUN mkdir -p ${CATALINA_HOME}/deploy/
RUN wget http://edas-hz.oss-cn-hangzhou.aliyuncs.com/edas-plugins/edas.sar.${EDAS_CONTAINER_VERSION}/taobao-hsf.tgz -O /tmp/taobao-hsf.tgz && \
    tar -xvf /tmp/taobao-hsf.tgz -C ${CATALINA_HOME}/deploy/ && \
    rm -rf /tmp/taobao-hsf.tgz
# 下载部署 EDAS 演示 JAR 包

ENV INSTALL_DIR=/home/admin/app
ENV APP_PACKAGE=APP_NAME_VERSION.jar
COPY SERVICE_MODULE_NAME/target/${APP_PACKAGE} ${INSTALL_DIR}/

# 将启动命令写入启动脚本 start.sh
RUN echo '$JAVA_HOME/bin/java -jar $CATALINA_OPTS -Djava.security.egd=file:/dev/./urandom -Dcatalina.logs=$CATALINA_HOME/logs -Dpandora.location=$CATALINA_HOME/deploy/taobao-hsf.sar  ${INSTALL_DIR}/${APP_PACKAGE} --spring.profiles.active=SPRING_PROFILES_ACTIVE --server.tomcat.uri-encoding=UTF-8 --server.tomcat.max-threads=400' > /home/admin/start.sh && chmod +x /home/admin/start.sh

WORKDIR $CATALINA_HOME
CMD ["/bin/bash", "/home/admin/start.sh"]
