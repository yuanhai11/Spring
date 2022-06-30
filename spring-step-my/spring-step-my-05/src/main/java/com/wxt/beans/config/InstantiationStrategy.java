package com.wxt.beans.config;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object Instantiation(BeanDefinition beanDefinition, String beanName, Constructor constructor,Object ... args);
}
