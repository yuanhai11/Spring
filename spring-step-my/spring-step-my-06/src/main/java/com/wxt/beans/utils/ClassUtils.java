package com.wxt.beans.utils;

public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {

        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {

        }
        return cl == null ? cl : ClassUtils.class.getClassLoader();
    }
}
