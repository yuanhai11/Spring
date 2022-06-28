package com.wxt.beans.property;

import java.util.ArrayList;
import java.util.List;

public class PropertyValue {

    private final String name;

    private final Object value;

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

    public static void main(String[] args) {
        final List<PropertyValue> propertyValueList = new ArrayList<>();
        PropertyValue[] values = new PropertyValue[0];
        System.out.println(propertyValueList.toArray(values) );
    }
}
