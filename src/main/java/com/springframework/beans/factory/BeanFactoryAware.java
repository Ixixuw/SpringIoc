package com.springframework.beans.factory;

import com.springframework.beans.BeansException;

/**
 * 实现此接口既能感知到所属的 BeanFactory
 * @author wuxx
 */
public interface BeanFactoryAware extends Aware{
    /**
     * 修改 BeanFactory
     * @param beanFactory
     * @throws BeansException
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
