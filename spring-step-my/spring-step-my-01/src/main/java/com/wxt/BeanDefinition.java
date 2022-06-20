package com.wxt;

public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object object) {
        this.bean = object;
    }

    public Object getBean() {
        return bean;
    }

}
