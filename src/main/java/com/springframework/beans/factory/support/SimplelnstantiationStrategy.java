package com.springframework.beans.factory.support;

import com.springframework.beans.factory.config.BeanDefinition;
import com.springframework.beans.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/**
 * JDK实例化
 * */
public class SimplelnstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        //获取Class信息
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                //有参构造实例化
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                //无参构造实例化
                return clazz.getDeclaredConstructor().newInstance();
            }
        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
           throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
