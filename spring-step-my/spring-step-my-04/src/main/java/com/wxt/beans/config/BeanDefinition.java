package com.wxt.beans.config;

import com.wxt.beans.property.PropertyValues;

public class BeanDefinition {

    private Class beanClass;
    private PropertyValues PropertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.PropertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass ,PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.PropertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }


    public com.wxt.beans.property.PropertyValues getPropertyValues() {
        return PropertyValues;
    }

    public void setPropertyValues(com.wxt.beans.property.PropertyValues propertyValues) {
        PropertyValues = propertyValues;
    }
}
