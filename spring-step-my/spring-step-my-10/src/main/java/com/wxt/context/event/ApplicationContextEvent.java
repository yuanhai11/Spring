package com.wxt.context.event;

import com.wxt.context.ApplicationContext;

/**
 * 作为一个基类，供外部使用
 */

public class ApplicationContextEvent extends ApplicationEvent{
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
