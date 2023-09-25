package org.example.beans.factory.config;

import org.example.beans.factory.ConfigurableListableBeanFactory;
import org.example.exception.BeansException;

/**
 * @author zhp
 * @date 2023/9/19 13:51
 **/
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
