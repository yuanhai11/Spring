package com.wxt.context;

import com.wxt.exception.BeansException;
import com.wxt.factory.aware.Aware;

/**
 * 实现此接口，感知到所属的ApplicationContext
 */
public interface ApplicationContextAware extends Aware {


    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
