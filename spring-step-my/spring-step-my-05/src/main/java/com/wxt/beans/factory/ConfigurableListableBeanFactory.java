package com.wxt.beans.factory;

import com.wxt.beans.config.BeanDefinition;
import com.wxt.beans.exception.BeansException;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory,AutowireCapableBeanFactory,ConfigurableBeanFactory{

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
