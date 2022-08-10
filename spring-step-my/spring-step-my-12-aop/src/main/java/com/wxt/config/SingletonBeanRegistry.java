package com.wxt.config;

/**
 * 注册表 针对单例对象
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object o);

}
