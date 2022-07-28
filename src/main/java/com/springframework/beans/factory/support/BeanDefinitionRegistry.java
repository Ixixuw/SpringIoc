package com.springframework.beans.factory.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.config.BeanDefinition;
/**
 * @author wuxx
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册beanDefinition
     * @param beanName
     * @param beanDefinition
     * */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用Bean名称查询beanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     * */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     *判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     * */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有的Bean名称
     * @return
     */
    String[] getBeanDefinitionNames();


}
