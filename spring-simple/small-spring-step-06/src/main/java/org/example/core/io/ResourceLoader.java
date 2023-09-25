package org.example.core.io;

/**
 * @author zhp
 * @date 2023/9/14 11:49
 **/
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
