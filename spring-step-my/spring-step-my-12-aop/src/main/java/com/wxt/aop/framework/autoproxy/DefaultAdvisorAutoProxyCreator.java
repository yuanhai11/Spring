package com.wxt.aop.framework.autoproxy;

import com.wxt.aop.*;
import com.wxt.aop.aspectj.AspectJExpressionPointcutAdvisor;
import com.wxt.aop.framework.ProxyFactory;
import com.wxt.exception.BeansException;
import com.wxt.factory.BeanFactory;
import com.wxt.factory.aware.BeanFactoryWare;
import com.wxt.factory.aware.InstantiationAwareBeanPostProcessor;
import com.wxt.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryWare {

    private DefaultListableBeanFactory beanFactory;


    public void setBeanFactory(BeanFactory beanFactory) throws BeansException{
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        if (isInfrastructureClass(beanClass)) return null;
        Collection<AspectJExpressionPointcutAdvisor> values = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : values) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(beanClass)) {
                continue;
            }
            AdvisedSupport advisedSupport = new AdvisedSupport();
            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }

            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);
            return new ProxyFactory(advisedSupport).getProxy();
        }
        return null;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) ||
                PointCut.class.isAssignableFrom(beanClass) ||
                Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


}
