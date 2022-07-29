package com.springframework.beans.factory;

import com.springframework.beans.BeansException;
import com.springframework.context.ApplicationContext;

/**
 * @author wuxx
 * 实现此接口，感知所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware{

    /**
     * 修改对应的ApplicationContext
     * @param applicationContext
     * @throws BeansException
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
