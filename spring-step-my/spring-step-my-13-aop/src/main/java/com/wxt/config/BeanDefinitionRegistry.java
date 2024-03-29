package com.wxt.config;

/**
 * 注册表 针对BeanDefinition
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String name, BeanDefinition definition);

    BeanDefinition getBeanDefinition(String beanName);

    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();


}
