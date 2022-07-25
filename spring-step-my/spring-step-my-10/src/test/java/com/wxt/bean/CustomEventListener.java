package com.wxt.bean;

import com.wxt.context.event.ApplicationLister;

import java.util.Date;

public class CustomEventListener implements ApplicationLister<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {

        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
