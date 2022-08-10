package com.wxt.support;

import com.wxt.config.DisposableBean;
import com.wxt.config.SingletonBeanRegistry;
import com.wxt.exception.BeansException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    public static final Object NULL_OBJECT = new Object();
    private Map<String, Object> map = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return map.get(beanName);
    }

    public void registerSingleton(String beanName, Object bean) {
        map.put(beanName, bean);
    }


    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
