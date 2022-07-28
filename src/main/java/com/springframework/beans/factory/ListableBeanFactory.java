package com.springframework.beans.factory;

import com.springframework.beans.BeansException;

import java.util.Map;
/**
 * @author wuxx
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @return
     * @throws BeansException
     * */
   <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

   /**
    * 返回注册表中所有 Bean 的名称
    * @return
    * */
   String[] getBeanDefinitionNames();
}
