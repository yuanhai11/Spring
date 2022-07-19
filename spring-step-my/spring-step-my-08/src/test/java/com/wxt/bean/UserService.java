package com.wxt.bean;

import com.wxt.context.ApplicationContext;
import com.wxt.context.ApplicationContextAware;
import com.wxt.exception.BeansException;
import com.wxt.factory.BeanFactory;
import com.wxt.factory.aware.BeanClassLoaderAware;
import com.wxt.factory.aware.BeanFactoryWare;
import com.wxt.factory.aware.BeanNameWare;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class UserService implements BeanNameWare, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryWare {

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;


    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        System.out.println("ClassLoader:" + beanClassLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Name:" + name);

    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
