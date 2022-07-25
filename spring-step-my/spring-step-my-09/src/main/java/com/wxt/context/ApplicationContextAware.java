package com.wxt.context;

import com.wxt.exception.BeansException;
import com.wxt.factory.aware.Aware;

public interface ApplicationContextAware extends Aware {

    /**
     * 实现此接口，感知到所属的ApplicationContext
     * @param applicationContext
     * @throws BeansException
     */

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
