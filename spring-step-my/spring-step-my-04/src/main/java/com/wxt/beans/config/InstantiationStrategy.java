package com.wxt.beans.config;

import com.wxt.beans.exception.BeansException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args)throws BeansException;
}
