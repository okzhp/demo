package org.example.beans.factory.support;

import org.example.exception.BeansException;
import org.example.core.io.Resource;
import org.example.core.io.ResourceLoader;

/**
 * @author zhp
 * @date 2023/9/14 13:49
 * 前两个接口是为后三个接口提供服务
 **/
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegister();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
