package com.wxt.aop;


/**
 * 切入点入口
 */
public interface PointCut {

    /**
     * 匹配到符合的类
     * @return
     */
    ClassFilter getClassFilter();

    /**
     * 匹配到符合的方法
     * @return
     */
    MethodMatcher getMethodMatcher();


}
