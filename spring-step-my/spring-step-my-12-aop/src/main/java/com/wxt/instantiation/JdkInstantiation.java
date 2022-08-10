package com.wxt.instantiation;

import com.wxt.config.BeanDefinition;
import com.wxt.exception.BeansException;

import java.lang.reflect.Constructor;

public class JdkInstantiation implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (ctor == null) {
                return beanClass.getDeclaredConstructor().newInstance();
            }
            return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
