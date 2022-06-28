package com.wxt.beans.factory.support;

import com.wxt.beans.factory.BaseException;
import com.wxt.beans.factory.config.BeanDefinition;
import com.wxt.beans.factory.config.InstantiationStrategy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class CglibInstantiationStrategy implements InstantiationStrategy {
    // cglib具体实现
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) throws BaseException {
        Enhancer enhancer = new Enhancer(); // 利用字节码框架ASM
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (ctor == null) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
