package com.wxt.beans.support;

import cn.hutool.core.bean.BeanUtil;
import com.wxt.beans.config.BeanDefinition;
import com.wxt.beans.config.BeanReference;
import com.wxt.beans.config.InstantiationStrategy;
import com.wxt.beans.exception.BeansException;
import com.wxt.beans.property.PropertyValue;
import com.wxt.beans.property.PropertyValues;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiate = new CglibInstantiationStrategy();

    public InstantiationStrategy getInstantiate() {
        return instantiate;
    }

    public void setInstantiate(InstantiationStrategy instantiate) {
        this.instantiate = instantiate;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName,bean,beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiate().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {

            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                // service里需要dao对象，所以传入dao实例，进行判断先取出来。
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());

                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }

    }

}
