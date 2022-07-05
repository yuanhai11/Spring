package com.wxt.beans.config;

import com.wxt.beans.exception.BeansException;
import com.wxt.beans.resource.Resource;
import com.wxt.beans.resource.ResourceLoader;

public interface BeanDefinitionReader {
    /**
     * 进化一步，把BeanDefinition内置化，直接xml解析的时候进行BeanDefinition的注册
     */

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String path) throws BeansException;

    void loadBeanDefinitions(String... path) throws BeansException;

}
