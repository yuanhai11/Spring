package com.wxt.test;

import com.wxt.aop.AdvisedSupport;
import com.wxt.aop.MethodMatcher;
import com.wxt.aop.TargetSource;
import com.wxt.aop.aspectj.AspectJExpressionPointcut;
import com.wxt.aop.framework.CglibAopProxy;
import com.wxt.aop.framework.JdkAopProxy;
import com.wxt.aop.framework.ReflectiveMethodInvocation;
import com.wxt.context.support.ClassPathXmlApplicationContext;
import com.wxt.test.service.IUserService;
import com.wxt.test.service.UserService;
import com.wxt.test.service.UserServiceInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ApiTest {

    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserService();

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.wxt.test.service.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new CglibAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }

    @Test
    public void test() {

        IUserService targetObj = new UserService();
        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {

            // 方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* com.wxt.test.service.IUserService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    MethodInterceptor methodInterceptor = invocation -> {
                        long l = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("监控开始！！！");
                            System.out.println("方法名称：" + invocation.getMethod().getName());
                            System.out.println("监控结束！！！");
                        }

                    };
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });

        String info = proxy.queryUserInfo();
        System.out.println(info);

    }

    @Test
    public void test_() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = classPathXmlApplicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


}
