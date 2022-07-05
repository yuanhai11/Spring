package com.wxt;

import cn.hutool.core.io.IoUtil;
import com.wxt.bean.UserService;
import com.wxt.beans.config.BeanDefinition;
import com.wxt.beans.config.BeanReference;
import com.wxt.beans.resource.Resource;
import com.wxt.beans.resource.DefaultResourceLoader;
import com.wxt.beans.property.PropertyValue;
import com.wxt.beans.property.PropertyValues;
import com.wxt.beans.support.DefaultListableBeanFactory;
import com.wxt.beans.xml.XmlBeanDefinitionReader;
import com.wxt.common.MyBeanFactoryPostProcessor;
import com.wxt.common.MyBeanPostProcessor;
import com.wxt.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

}
