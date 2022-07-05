package com.wxt.beans.instantiation;

import com.wxt.beans.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    // 实例化策略
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args);

}
