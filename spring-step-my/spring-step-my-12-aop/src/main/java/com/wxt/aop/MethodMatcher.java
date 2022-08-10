package com.wxt.aop;

import java.lang.reflect.Method;

/**
 * 定义类匹配类，用于切点找到给定的接口和目标类
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> clazz);
}
