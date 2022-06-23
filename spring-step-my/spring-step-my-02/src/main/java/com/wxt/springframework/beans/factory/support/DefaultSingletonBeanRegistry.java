package com.wxt.springframework.beans.factory.support;

import com.wxt.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String,Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

}
