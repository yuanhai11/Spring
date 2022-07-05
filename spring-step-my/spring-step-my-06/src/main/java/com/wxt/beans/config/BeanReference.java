package com.wxt.beans.config;

public class BeanReference {
    /**
     * 对UserDao这样的对象进行一层包装。
     */
    private final String name;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
