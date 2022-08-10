package com.wxt.factory.aware;

public interface BeanClassLoaderAware extends Aware {
    /**
     * 实现此aware就可以感知到ClassLoader
     */
    void setBeanClassLoader(ClassLoader beanClassLoader);

}
