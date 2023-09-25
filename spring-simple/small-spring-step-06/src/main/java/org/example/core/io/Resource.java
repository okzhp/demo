package org.example.core.io;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author zhp
 * @date 2023/9/14 10:39
 * 读取配置文件的接口
 **/
public interface Resource {
    InputStream getInputStream() throws IOException;
}
