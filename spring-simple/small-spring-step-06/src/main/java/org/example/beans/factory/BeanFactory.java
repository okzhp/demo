package org.example.beans.factory;

import org.example.exception.BeansException;

/**
 * @author zhp
 * @date 2023/9/12 16:59
 **/
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName,Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
