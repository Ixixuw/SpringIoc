package com.springframework.util;

public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader =Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }
        if (classLoader == null) {
            // 没有线程上下文类加载器- >使用类加载器
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
}
