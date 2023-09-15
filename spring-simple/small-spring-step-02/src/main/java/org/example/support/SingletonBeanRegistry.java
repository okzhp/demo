package org.example.support;

/**
 * @author zhp
 * @date 2023/9/12 17:15
 **/
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
