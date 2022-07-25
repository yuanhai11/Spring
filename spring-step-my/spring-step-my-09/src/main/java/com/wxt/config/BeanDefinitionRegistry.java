package com.wxt.config;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String name, BeanDefinition definition);

    BeanDefinition getBeanDefinition(String beanName);

    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();


}
