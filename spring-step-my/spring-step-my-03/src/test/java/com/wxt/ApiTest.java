package com.wxt;

import com.wxt.beans.factory.config.BeanDefinition;
import com.wxt.beans.factory.support.DefaultListableBeanFactory;
import com.wxt.service.UserService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

public class ApiTest {
    @Test
    public void test0() {
        // 初始化beanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        factory.registerBeanDefinition("userService", beanDefinition);
        // 获取bean
        UserService service = (UserService) factory.getBean("userService", "小王");
        service.queryUserInfo();

    }

    // 下面两个方法都是把创建过程交给了外边，没有IOC容器概念。

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"小傅哥"});
        System.out.println(obj);
    }

}
