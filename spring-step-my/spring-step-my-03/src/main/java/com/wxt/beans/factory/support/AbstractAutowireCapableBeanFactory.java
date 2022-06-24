package com.wxt.beans.factory.support;

import com.wxt.beans.factory.BaseException;
import com.wxt.beans.factory.config.BeanDefinition;
import com.wxt.beans.factory.config.InstantiationStrategy;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    // Cglib实例化带参数的
    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();
    // JDK实例化带参数的
    private InstantiationStrategy instantiationStrategy1 = new JdkInstantiationStrategy();


    @Override
    public Object createBean(String beanName, BeanDefinition beanDefinition,  Object... args) throws BaseException {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BaseException("instance bean failed");
        }
        addSingleton(beanName, bean);
        return bean;
    }

    public Object createBeanInstance(BeanDefinition beanDefinition, String beanName,  Object... args) {
        Constructor constructor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : constructors) {
            if (ctor.getParameterTypes().length == args.length && null != args) {
                constructor = ctor;
                break;
            }
        }
        return instantiationStrategy1.instantiate(beanDefinition, beanName, constructor, args);
    }


}
