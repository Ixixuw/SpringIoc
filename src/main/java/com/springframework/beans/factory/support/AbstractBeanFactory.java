package com.springframework.beans.factory.support;

import com.springframework.beans.factory.FactoryBean;
import com.springframework.beans.factory.config.BeanDefinition;
import com.springframework.beans.BeansException;
import com.springframework.beans.factory.config.BeanPostProcessor;
import com.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * @author wuxx
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /** ClassLoader 用于解析 Bean 类名（如有必要） */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /** BeanPostProcessors 用于创建Bean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
    /**
     * 对单例bean的获取，若获取不到进行对应的实例化bean操作
     * */
    @Override
    public Object getBean(String name) throws BeansException {

        return doGetBean(name, null);

    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }
    protected <T> T doGetBean(final String name, final Object[] args) {
        Object shareInstance = getSingleton(name);
        if (shareInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForInstance(shareInstance, name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForInstance(bean, name);
    }

    private Object getObjectForInstance(Object beanInstance, String beanName) {

        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }

    /**
     * 根据beanName得到对应Bean缓存
     * @param beanName 名称
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 存入缓存
     * @param beanName bean名字
     * @param beanDefinition bean缓存
     * @param args 构造函数的参数
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
