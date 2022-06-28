package com.wxt.beans.factory.config;

public interface SingleonBeanRegistry {
    Object getSingleton(String beanName);
}
