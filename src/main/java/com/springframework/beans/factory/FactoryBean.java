package com.springframework.beans.factory;

/**
 * @param <T>
 * @author wuxx
 */
public interface FactoryBean<T> {
    /**
     * 获取对象
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 获取对象类型
     * @return
     */
    Class<?> getObjectType();

    /**
     * 是否为单例对象
     * @return
     */
    boolean isSingleton();
}
