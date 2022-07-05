package com.wxt.beans.property;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    // 增加PropertyValue
    public void addPropertyValue(PropertyValue value) {
        this.propertyValueList.add(value);
    }

    // 获取数组，包含所有属性
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    // 根据name 获取指定的PropertyValue。
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue value : this.propertyValueList) {
            if (value.getName().equals(propertyName)) {
                return value;
            }
        }
        return null;
    }

}
