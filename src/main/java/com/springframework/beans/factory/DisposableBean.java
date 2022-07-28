package com.springframework.beans.factory;
/**
 * @author wuxx
 */
public interface DisposableBean {
    /**
     * 销毁bean
     * @throws Exception
     */
    void destroy() throws Exception;
}
