package com.wxt.aop;

public interface PointcutAdvisor extends Advisor{
    /**
     * get the PointCut that drives this advisor
     */
    PointCut getPointcut();
}
