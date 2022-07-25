package com.wxt.utils;

public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {

        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {

        }
        return cl == null ? cl : ClassUtils.class.getClassLoader();
    }

    public static boolean isCglibProxyClass(Class clazz) {

        return (clazz != null && isCglibProxyClassName(clazz.getName()));

    }

    public static boolean isCglibProxyClassName(String className) {
        return (className != null && className.contains("$$"));
    }
}
