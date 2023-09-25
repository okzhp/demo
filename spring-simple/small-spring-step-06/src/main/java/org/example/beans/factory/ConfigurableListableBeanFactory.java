package org.example.beans.factory;

import org.example.beans.factory.config.AutowireCapableBeanFactory;
import org.example.beans.factory.config.ConfigurableBeanFactory;
import org.example.exception.BeansException;

/**
 * @author zhp
 * @date 2023/9/21 10:01
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
