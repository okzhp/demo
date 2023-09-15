package org.example.io;

import cn.hutool.core.lang.Assert;
import org.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhp
 * @date 2023/9/14 10:44
 **/
public class ClassPathResource implements Resource{

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path){
        this(path, null);
    }

    public ClassPathResource(String path,ClassLoader classLoader){
        Assert.notNull(path);
        this.path = path;
        this.classLoader = classLoader == null? ClassUtils.getDefaultClassLoader():classLoader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null){
            throw new FileNotFoundException(path + "文件不存在!");
        }
        return is;
    }
}
