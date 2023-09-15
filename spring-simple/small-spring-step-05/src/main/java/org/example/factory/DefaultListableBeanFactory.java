package org.example.factory;

import org.example.support.AbstractAutowireCapableBeanFactory;
import org.example.support.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhp
 * @date 2023/9/12 17:52
 **/
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public void registry(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }

}
