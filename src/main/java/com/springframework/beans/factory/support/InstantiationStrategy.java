package com.springframework.beans.factory.support;

import com.springframework.beans.factory.config.BeanDefinition;
import com.springframework.beans.BeansException;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    /**
     * @param beanDefinition bean缓存对象
     * @param beanName bean名字
     * @param ctor 符合入参信息相对应的构造函数
     * @param args 具体入参信息
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
