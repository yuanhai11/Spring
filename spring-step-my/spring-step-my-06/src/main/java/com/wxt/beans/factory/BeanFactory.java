package com.wxt.beans.factory;

import com.wxt.beans.exception.BeansException;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> type) throws BeansException;
}
