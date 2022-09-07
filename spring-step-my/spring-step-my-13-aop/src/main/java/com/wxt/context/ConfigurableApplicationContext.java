package com.wxt.context;

import com.wxt.exception.BeansException;

/**
 * SPI interface to be implemented by most if not all application contexts,
 * Provides facilities to configure an application context in addition to
 * the application context client methods in the ApplicationContext interface.
 * 大多数应用程序上下文接口都会实现SPI接口，除了com.wxt.bean.context.ApplicationContext外，
 **/
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();

}
