package com.wxt.config;

import com.wxt.exception.BeansException;
import com.wxt.resource.Resource;
import com.wxt.resource.ResourceLoader;

public interface BeanDefinitionReader {

    /**
     * 读取资源的类
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String resource) throws BeansException;

    void loadBeanDefinitions(String... resource) throws BeansException;
}
