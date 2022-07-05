package com.wxt.common;

import com.wxt.beans.config.BeanDefinition;
import com.wxt.beans.exception.BeansException;
import com.wxt.beans.factory.BeanFactoryPostProcessor;
import com.wxt.beans.factory.ConfigurableListableBeanFactory;
import com.wxt.beans.property.PropertyValue;
import com.wxt.beans.property.PropertyValues;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
