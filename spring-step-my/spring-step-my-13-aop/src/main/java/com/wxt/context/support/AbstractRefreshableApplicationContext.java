package com.wxt.context.support;

import com.wxt.exception.BeansException;
import com.wxt.factory.ConfigurableListableBeanFactory;
import com.wxt.support.DefaultListableBeanFactory;

/**
 * 对模板方法中的AbstractApplicationContext的方法的具体实现，同时使用模板方法实现加载资源。
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;

    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}
