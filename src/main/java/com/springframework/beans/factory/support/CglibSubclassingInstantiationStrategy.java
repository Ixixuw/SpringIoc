package com.springframework.beans.factory.support;

import com.springframework.beans.factory.config.BeanDefinition;
import com.springframework.beans.BeansException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;
/**
 * Cglib实例化
 * @author wuxx
 * */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) {
            //无参构造实例化
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
