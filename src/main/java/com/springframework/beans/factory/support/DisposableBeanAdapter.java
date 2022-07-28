package com.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.springframework.beans.BeansException;
import com.springframework.beans.factory.DisposableBean;
import com.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * 销毁方法适配器,希望有个统一接口进行销毁
 * @author wuxx
 * */
public class DisposableBeanAdapter implements DisposableBean {

    private static final String DESTROY = "destroy";

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        //1.实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        //2.配置信息 destroy-method {判断是为了避免二次销毁}
        boolean flag = StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && DESTROY.equals(this.destroyMethodName));
        if (flag) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named " + destroyMethodName + " on bean with name " + beanName + " ");
            }
            destroyMethod.invoke(bean);
        }
    }
}
