package com.wxt.context.event;

public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * 事件刷新动作
     */

    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
