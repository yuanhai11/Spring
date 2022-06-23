package com.wxt.springframework.beans.factory.config;

public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition);
}
