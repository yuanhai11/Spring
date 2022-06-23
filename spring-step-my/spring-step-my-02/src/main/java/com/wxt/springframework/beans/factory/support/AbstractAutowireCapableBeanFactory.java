package com.wxt.springframework.beans.factory.support;

import com.wxt.springframework.beans.BeansException;
import com.wxt.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    public Object createBean(String beanName, BeanDefinition definition)throws BeansException {
        Object bean = null;
        try {
            bean = definition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("bean can not is null");
        }
        addSingleton(beanName,bean);
        return bean;
    }
}
