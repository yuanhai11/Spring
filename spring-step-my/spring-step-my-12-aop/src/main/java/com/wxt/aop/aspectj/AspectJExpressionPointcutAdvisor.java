package com.wxt.aop.aspectj;

import com.wxt.aop.ClassFilter;
import com.wxt.aop.MethodMatcher;
import com.wxt.aop.PointCut;
import com.wxt.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * 简单实现 切点表达式类
 * Spring
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    //
    private AspectJExpressionPointcut pointcut;
    //
    private Advice advice;
    //
    private String expression;

    public void setPointcut(AspectJExpressionPointcut pointcut) {
        this.pointcut = pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public PointCut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
