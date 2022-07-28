package com.springframework.context.support;

import com.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 上下文中对配置信息的加载
 * @author wuxx
 * */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if(null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     *为了从入口上下文类，拿到配置信息的地址描述
     * @return Location数组
     * */
    protected abstract String[] getConfigLocations();
}
