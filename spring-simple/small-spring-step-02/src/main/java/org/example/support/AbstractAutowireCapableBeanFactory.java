package org.example.support;

import org.example.factory.BeanDefinition;

/**
 * @author zhp
 * @date 2023/9/12 17:45
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        addSingleton(beanName,bean);
        return bean;
    }
}
