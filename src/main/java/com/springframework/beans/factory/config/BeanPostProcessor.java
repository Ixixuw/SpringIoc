package com.springframework.beans.factory.config;

import cn.hutool.core.bean.BeanException;

public interface BeanPostProcessor {

    /**
     * 在Bean对象执行初始化方法之前，执行此方法
     * */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException;

    /**
     * 在bean对象执行初始化方法之后，执行此方法
     * */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException;

}
