package com.wxt.springframework.beans.factory.support;

import com.wxt.springframework.beans.factory.BeanFactory;
import com.wxt.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) {
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }
        BeanDefinition definition = getBeanDefinition(beanName);
        return createBean(beanName, definition);
    }

    public abstract BeanDefinition getBeanDefinition(String beanName);

    public abstract Object createBean(String beanName, BeanDefinition definition);


}
