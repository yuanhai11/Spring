package com.wxt.beans.config;

/**
 * Bean注册接口
 */
public interface BeanDefinitionRegistry {

    // BeanDefinition的注册操作
    void registerBeanDefinition(String name, BeanDefinition definition);

    // 获取操作
    BeanDefinition getBeanDefinition(String beanName);

    // 包含操作
    boolean containsBeanDefinition(String beanName);

    // 获取所有Definition的名称
    String[] getBeanDefinitionNames();

}
