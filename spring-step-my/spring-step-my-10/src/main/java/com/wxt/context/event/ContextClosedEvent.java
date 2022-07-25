package com.wxt.context.event;

public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * 监听事件关闭动作
     */

    public ContextClosedEvent(Object source) {
        super(source);
    }
}
