package com.wxt.beans.factory.support;

import com.wxt.beans.factory.BaseException;
import com.wxt.beans.factory.BeanFactory;
import com.wxt.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BaseException {
        return doGetBean(name, args);

    }

    public <T> T doGetBean(String name,  Object... args) {
        Object singleton = getSingleton(name);
        if (singleton != null) {
            return (T)singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name, beanDefinition,args);
    }


    public abstract BeanDefinition getBeanDefinition(String beanName) throws BaseException;

    public abstract Object createBean(String beanName, BeanDefinition beanDefinition,  Object... args) throws BaseException;


}
