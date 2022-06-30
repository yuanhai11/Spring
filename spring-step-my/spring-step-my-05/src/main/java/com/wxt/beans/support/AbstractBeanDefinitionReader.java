package com.wxt.beans.support;

import com.wxt.beans.config.BeanDefinitionReader;
import com.wxt.beans.config.BeanDefinitionRegistry;
import com.wxt.beans.core.io.ResourceLoader;
import com.wxt.beans.core.io.impl.DefaultResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry,new DefaultResourceLoader());
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }


    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }


}
