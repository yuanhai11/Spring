package com.wxt.beans.config;

import com.wxt.beans.core.io.Resource;
import com.wxt.beans.core.io.ResourceLoader;
import com.wxt.beans.exception.BeansException;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String resource) throws BeansException;

}
