package com.wxt.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * 包装切面通知信息
 * 把代理对象，方法拦截器，方法匹配的功能点汇聚，方便后期的调用
 *
 */
public class AdvisedSupport {

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    // proxy代理config
    private boolean proxyTargetClass = false;
    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    //代理对象
    private TargetSource targetSource;
    //方法拦截器
    private MethodInterceptor methodInterceptor;
    //方法匹配器（检查目标方法是否符合条件）
    private MethodMatcher methodMatcher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
