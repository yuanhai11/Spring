package com.wxt.factory;

import com.wxt.exception.BeansException;

public interface BeanPostProcessor {

    /**
     * @param bean
     * @param beanName
     * @return bean实例化之前执行
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * @param bean
     * @param beanName
     * @return bean实例化之后执行
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
