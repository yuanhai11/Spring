package com.wxt.instantiation;

import com.wxt.config.BeanDefinition;
import com.wxt.exception.BeansException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) throws BeansException;
}
