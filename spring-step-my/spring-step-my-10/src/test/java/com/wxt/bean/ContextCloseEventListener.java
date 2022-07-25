package com.wxt.bean;

import com.wxt.context.event.ApplicationLister;
import com.wxt.context.event.ContextClosedEvent;

public class ContextCloseEventListener implements ApplicationLister<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());

    }
}
