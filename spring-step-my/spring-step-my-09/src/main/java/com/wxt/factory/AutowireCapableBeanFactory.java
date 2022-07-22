package com.wxt.factory;

import com.wxt.exception.BeansException;

public interface AutowireCapableBeanFactory extends BeanFactory{


    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;


}
