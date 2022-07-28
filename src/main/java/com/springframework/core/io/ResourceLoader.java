package com.springframework.core.io;
/**
 * 定义获取资源接口
 * @author wuxx
 * */
public interface ResourceLoader {
    /**
     * 用于从类路径加载的伪 URL 前缀: “ classspath:”
     * */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 根据路径获取资源文件
     * @param location
     * @return
     */
    Resource getResource(String location);
}
