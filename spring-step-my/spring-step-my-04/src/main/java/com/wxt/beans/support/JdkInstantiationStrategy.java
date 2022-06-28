package com.wxt.beans.support;

import com.wxt.beans.config.BeanDefinition;
import com.wxt.beans.config.InstantiationStrategy;
import com.wxt.beans.exception.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JdkInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (clazz != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
