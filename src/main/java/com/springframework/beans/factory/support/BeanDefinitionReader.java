package com.springframework.beans.factory.support;

import com.springframework.beans.BeansException;
import com.springframework.core.io.Resource;
import com.springframework.core.io.ResourceLoader;
/**
 * bean定义读取接口
 * @author wuxx
 * */
public interface BeanDefinitionReader {
    /**
     *获取一个注册接口
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     *获取一个资源接口
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     *通过资源文件加载Bean到BeanDefinitions
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     *多个资源的加载
     * @param resources
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     *路径加载
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     *多个路径加载
     * @param locations
     * @throws BeansException
     */
    void loadBeanDefinitions(String... locations) throws BeansException;
}
