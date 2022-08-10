package com.wxt.aop;


import java.lang.reflect.Method;

/**
 * Advice invoked before a method is invoked.
 * 有一个方法调用之前被调用的通知。
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
    void before(Method method, Object[] args, Object target) throws Throwable;
}
