package com.wxt.factory.aware;

import com.wxt.exception.BeansException;
import com.wxt.factory.BeanPostProcessor;

public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    /**
     * @param bean
     * @param beanName
     * @return bean实例化之前执行
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
