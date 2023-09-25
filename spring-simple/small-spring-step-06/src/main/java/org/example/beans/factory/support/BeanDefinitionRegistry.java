package org.example.beans.factory.support;

import org.example.beans.factory.BeanDefinition;

/**
 * @author zhp
 * @date 2023/9/12 17:58
 **/
public interface BeanDefinitionRegistry {
    void registry(String beanName, BeanDefinition beanDefinition);
}
