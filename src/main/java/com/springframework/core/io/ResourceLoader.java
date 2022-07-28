package com.springframework.core.io;
/**
 * 定义获取资源接口
 * */
public interface ResourceLoader {
    /**
     * 用于从类路径加载的伪 URL 前缀: “ classspath:”
     * */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
