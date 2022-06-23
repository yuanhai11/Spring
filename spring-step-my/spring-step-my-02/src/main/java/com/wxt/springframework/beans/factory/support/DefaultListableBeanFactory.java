package com.wxt.springframework.beans.factory.support;

import com.wxt.springframework.beans.BeansException;
import com.wxt.springframework.beans.factory.config.BeanDefinition;
import com.wxt.springframework.beans.factory.config.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException{
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("beanName is not exits");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}
