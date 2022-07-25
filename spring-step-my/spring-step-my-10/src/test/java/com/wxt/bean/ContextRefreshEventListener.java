package com.wxt.bean;

import com.wxt.context.event.ApplicationLister;
import com.wxt.context.event.ContextRefreshedEvent;

public class ContextRefreshEventListener implements ApplicationLister<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());

    }

}
