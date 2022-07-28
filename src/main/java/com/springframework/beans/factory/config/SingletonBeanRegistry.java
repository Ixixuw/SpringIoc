package com.springframework.beans.factory.config;
/**
 * 单例注册接口
 * */
public interface SingletonBeanRegistry {
    /**
     * 获取单例对象
     * */
    Object getSingleton(String beanName);
}
