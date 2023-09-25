package org.example.beans.factory.support;

import org.example.beans.factory.BeanFactory;
import org.example.beans.factory.BeanDefinition;
import org.example.exception.BeansException;

/**
 * @author zhp
 * @date 2023/9/12 17:19
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        return dogetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName,Object... args) throws BeansException{
        return dogetBean(beanName,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T dogetBean(final String name,final Object[] args){
        Object bean = getSingleton(name);
        if (bean != null){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name,beanDefinition,args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object... args);
}
