package com.wxt.utils;

/**
 * 具体的事件
 */

public class EventObject {

    // 事件最初的来源
    private Object source;

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public EventObject(Object source) {
        this.source = source;
    }

}
