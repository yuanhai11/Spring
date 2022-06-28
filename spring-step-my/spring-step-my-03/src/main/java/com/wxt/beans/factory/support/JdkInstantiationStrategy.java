package com.wxt.beans.factory.support;

import com.wxt.beans.factory.BaseException;
import com.wxt.beans.factory.config.BeanDefinition;
import com.wxt.beans.factory.config.InstantiationStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JdkInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) throws BaseException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (ctor != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BaseException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
