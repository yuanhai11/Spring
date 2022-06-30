package com.wxt.beans.support;

import com.wxt.beans.config.BeanDefinition;
import com.wxt.beans.config.InstantiationStrategy;
import com.wxt.beans.exception.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JdkInstantiationStragy implements InstantiationStrategy {


    @Override
    public Object Instantiation(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object... args) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (constructor != null) {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }
            return beanClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);

        }
    }
}
