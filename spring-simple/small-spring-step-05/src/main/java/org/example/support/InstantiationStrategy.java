package org.example.support;

import org.example.factory.BeanDefinition;
import org.springframework.beans.BeansException;

import java.lang.reflect.Constructor;

/**
 * @author zhp
 * @date 2023/9/13 14:02
 **/
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor,Object[] args) throws BeansException;
}
