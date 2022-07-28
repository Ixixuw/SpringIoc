package com.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;
/**
 * @author wuxx
 */
public interface Resource {
    /**
     * 获取 InputStream 流
     * @return
     * @throws  IOException
     * */
    InputStream getInputStream() throws IOException;
}
