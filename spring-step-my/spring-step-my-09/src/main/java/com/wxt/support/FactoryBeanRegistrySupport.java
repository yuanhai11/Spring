package com.wxt.support;

import com.wxt.exception.BeansException;
import com.wxt.factory.FactoryBean;

import java.util.concurrent.ConcurrentHashMap;

public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    private final ConcurrentHashMap<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    public Object getCacheObjectForFactoryBean(String beanName) {
        Object o = factoryBeanObjectCache.get(beanName);
        return o != NULL_OBJECT ? o : null;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.getCacheObjectForFactoryBean(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null) ? object : NULL_OBJECT);

            }
            return (object != NULL_OBJECT ? object : null);
        }
        return doGetObjectFromFactoryBean(factory, beanName);
    }

    private Object doGetObjectFromFactoryBean(FactoryBean factory, String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }

    }
}
