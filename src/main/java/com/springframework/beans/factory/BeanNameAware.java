package com.springframework.beans.factory;

/**
 * @author wuxx
 *实现此接口，感知所属的 BeanName
 */
public interface BeanNameAware extends Aware{

    /**
     *修改对应的 BeanName
     * @param name
     */
    void setBeanName(String name);
}
