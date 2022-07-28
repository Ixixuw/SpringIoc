package com.springframework.context.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.springframework.beans.factory.support.DefaultListableBeanFactory;
/**
 * 获取Bean工厂和加载资源
 * @author wuxx
 * */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;
    /**
     * 获取了 DefaultListableBeanFactory 的实例化以及对资源配置的加载操作 loadBeanDefinitions(beanFactory)，
     * 在加载完成后即可完成对 spring.xml 配置文件中 Bean 对象的定义和注册
     * */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载bean缓存
     * @param beanFactory
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
