package com.springframework.beans.factory.config;
/**
 * 单例注册接口
 * @author wuxx
 * */
public interface SingletonBeanRegistry {
    /**
     * 获取单例对象
     * @param beanName
     * @return
     * */
    Object getSingleton(String beanName);
}
