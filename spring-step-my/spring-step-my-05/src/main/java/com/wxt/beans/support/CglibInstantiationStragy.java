package com.wxt.beans.support;

import com.wxt.beans.config.BeanDefinition;
import com.wxt.beans.config.InstantiationStrategy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class CglibInstantiationStragy implements InstantiationStrategy {

    @Override
    public Object Instantiation(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object... args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp(){
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == constructor) return enhancer.create();
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
