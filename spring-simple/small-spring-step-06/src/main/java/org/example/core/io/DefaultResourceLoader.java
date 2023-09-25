package org.example.core.io;

import org.springframework.util.Assert;

import java.net.URL;

/**
 * @author zhp
 * @date 2023/9/14 11:51
 **/
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location,"location不能为null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }

        try {
            return new UrlResource(new URL(location));
        } catch (Exception e) {
            return new FileSystemResource(location);
        }
    }
}
