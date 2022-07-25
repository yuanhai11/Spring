package com.wxt;

import com.wxt.bean.CustomEvent;
import com.wxt.context.support.ClassPathXmlApplicationContext;
import com.wxt.dao.UserDao;
import com.wxt.dao.UserDaoImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class ApiTest {
    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 11000215, "success"));

        applicationContext.registerShutdownHook();

    }

    @Test
    public void test(){

        UserDao userDao = (UserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserDao.class}, (proxy, method, args) -> "你被代理了！");
        System.out.println(userDao.getClass());
        userDao.hello();
    }


}
