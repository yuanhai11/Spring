package com.wxt.beans.support;

import com.wxt.beans.config.BeanDefinition;
import com.wxt.beans.exception.BeansException;
import com.wxt.beans.factory.BeanFactory;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }


    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(String name, Object... args) throws BeansException {
        Object singleton = getSingleton(name);
        if (singleton != null) {
            return (T) singleton;
        }
        BeanDefinition definition = getBeanDefinition(name);

        return (T) createBean(name,definition,args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object... args);

}
