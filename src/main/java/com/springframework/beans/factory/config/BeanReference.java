package com.springframework.beans.factory.config;
/**
 * bean的引用
 * @author wuxx
 * */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
