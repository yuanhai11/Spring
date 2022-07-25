package com.wxt.bean;

import com.wxt.context.event.ApplicationContextEvent;
import com.wxt.context.support.ClassPathXmlApplicationContext;

public class CustomEvent extends ApplicationContextEvent {
    private long id;
    private String message;

    public CustomEvent(Object source,long id ,String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
