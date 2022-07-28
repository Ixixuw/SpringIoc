package com.springframework.beans.factory;

import com.springframework.beans.BeansException;

/***
 *bean工厂
 */

public interface BeanFactory {
    /**
     * 无参构造实例化
     * */
    Object getBean(String name) throws BeansException;
    /**
     * 有参构造实例化
     * */
    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
