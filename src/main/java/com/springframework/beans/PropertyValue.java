package com.springframework.beans;
/**
 * 传递类属性信息
 * @author wuxx
 * */
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
}
