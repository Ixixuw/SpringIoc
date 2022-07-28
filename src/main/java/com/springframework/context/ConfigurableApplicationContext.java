package com.springframework.context;

import com.springframework.beans.BeansException;
/**
 * @author wuxx
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     * */
    void refresh() throws BeansException;

    /**
     * 注册虚拟机钩子
     */
    void registerShutdownHook();

    /**
     * 关闭方法
     */
    void close();
}
