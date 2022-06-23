package com.wxt;

import com.wxt.springframework.beans.factory.config.BeanDefinition;
import com.wxt.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.wxt.springframework.service.UserService;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test() {
        /**
         * 接口：BeanFactory+ SingleBeanRegistry
         * 抽象类：
         */
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        factory.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService)factory.getBean("userService");
        userService.queryUserInfo();

        UserService userService_singleton = (UserService)factory.getBean("userService");
        userService_singleton.queryUserInfo();

        BeanDefinition beanDefinition1 = new BeanDefinition(UserService.class);
        factory.registerBeanDefinition("userService",beanDefinition1);


    }
}
