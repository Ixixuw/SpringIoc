package com.springframework.beans.factory;

/**
 * @author wuxx
 * 实现此接口，能感知到所属的ClassLoader
 */
public interface BeanClassLoaderAware extends Aware{

    /**
     * 修改对应的 ClassLoader
     * @param classLoader
     */
    void setBeanClassLoader(ClassLoader classLoader);
}
