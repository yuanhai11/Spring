package com.wxt;

import com.wxt.beans.config.BeanDefinition;
import com.wxt.beans.config.BeanReference;
import com.wxt.dao.UserDao;
import com.wxt.beans.property.PropertyValue;
import com.wxt.beans.property.PropertyValues;
import com.wxt.service.UserService;
import com.wxt.beans.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test0() {
        // 初始化创建工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 将对象注册进去
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 构造属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. 将对象和属性一起传入并创建对象
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 获取对象 & 同时也是动态创建对象的过程。
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
