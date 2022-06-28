package com.wxt.beans.factory.support;

import com.wxt.beans.factory.config.BeanDefinition;
import com.wxt.beans.factory.config.SingleonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingleonBeanRegistry {
    private final Map<String, Object> singletonMap = new HashMap<String, Object>();
    
    @Override
    public Object getSingleton(String beanName) {
        return singletonMap.get(beanName);
    }
    
    public void addSingleton(String beanName, Object beanDefinition) {
        singletonMap.put(beanName,beanDefinition);
        
    }
    
}
