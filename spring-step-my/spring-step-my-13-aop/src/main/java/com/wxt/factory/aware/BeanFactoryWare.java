package com.wxt.factory.aware;

import com.wxt.exception.BeansException;
import com.wxt.factory.BeanFactory;

public interface BeanFactoryWare extends Aware {

    /**
     * 容器感知类
     * desc: 实现此接口，就可以感知到beanFactory
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
