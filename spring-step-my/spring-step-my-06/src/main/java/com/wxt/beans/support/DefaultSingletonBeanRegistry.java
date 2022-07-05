package com.wxt.beans.support;

import com.wxt.beans.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return map.get(beanName);
    }

    public void addSingleton(String beanName, Object bean) {
        map.put(beanName, bean);
    }

}
