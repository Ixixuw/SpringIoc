package com.springframework.beans.factory;

import com.springframework.beans.BeansException;

/***
 *bean工厂
 * @author wuxx
 */
public interface BeanFactory {
    /**
     * 无参构造实例化
     * @param name
     * @return
     * @throws BeansException
     * */
    Object getBean(String name) throws BeansException;
    /**
     * 有参构造实例化
     * @param name
     * @param args 有参构造的参数
     * @return
     * @throws BeansException
     * */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     *返回泛型Bean
     * @param name
     * @param requiredType
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
