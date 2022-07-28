package com.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.springframework.beans.factory.config.BeanDefinition;
import com.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 处理对象扫描装配
 * @author wuxx
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
