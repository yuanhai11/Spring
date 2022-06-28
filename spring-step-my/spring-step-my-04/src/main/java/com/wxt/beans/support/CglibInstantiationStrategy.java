package com.wxt.beans.support;

import com.wxt.beans.config.BeanDefinition;
import com.wxt.beans.config.InstantiationStrategy;
import com.wxt.beans.exception.BeansException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class CglibInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (ctor == null) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
