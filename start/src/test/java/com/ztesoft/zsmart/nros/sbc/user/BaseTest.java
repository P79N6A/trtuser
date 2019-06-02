/**
 * Copyright (C), 2015-2018, 浩鲸科技有限公司
 * FileName: BaseTest
 * Author:   zhouyl5
 * Date:     2018/9/14/014 14:40
 * Description: 单测基础类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ztesoft.zsmart.nros.sbc.user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 〈单测基础类〉
 * @author zhouyl5
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NrosuserApplication.class)
public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);


    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @Test
    public void test() {
        logger.debug("BaseTest test start。。。");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }

}