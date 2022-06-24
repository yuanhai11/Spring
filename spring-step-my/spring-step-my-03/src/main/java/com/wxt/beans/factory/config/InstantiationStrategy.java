package com.wxt.beans.factory.config;

import com.wxt.beans.factory.BaseException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    // 实例化策略
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,  Object... args) throws BaseException;
}
