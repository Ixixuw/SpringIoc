package com.springframework.beans;

import com.springframework.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;
/**
 * 传递类属性信息，类属性过多采用集合
 * */
public class PropertyValues {



    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
