package com.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {
    /**
     * 获取 InputStream 流
     * */
    InputStream getInputStream() throws IOException;
}
