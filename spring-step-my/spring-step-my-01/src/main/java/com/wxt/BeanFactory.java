package com.wxt;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
    private Map<String, BeanDefinition> concurrentHashMap = new ConcurrentHashMap();

    public Object getBean(String name) {
        return concurrentHashMap.get(name).getBean();
    }


    public void registerBeanDefinition(String name, BeanDefinition bean) {
        concurrentHashMap.put(name, bean);
    }
}
