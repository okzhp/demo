package org.example.support;

import org.example.factory.BeanDefinition;

/**
 * @author zhp
 * @date 2023/9/12 17:58
 **/
public interface BeanDefinitionRegistry {
    void registry(String beanName, BeanDefinition beanDefinition);
}
