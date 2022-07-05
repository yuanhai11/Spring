package com.wxt.beans.property;

import java.util.ArrayList;
import java.util.List;

public class PropertyValue {

    private final String name;
    private final Object value;


    // final修饰属性，必须提供相应的构造器方法
    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
