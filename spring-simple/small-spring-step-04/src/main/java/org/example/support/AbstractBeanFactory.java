package org.example.support;

import org.example.BeanFactory;
import org.example.factory.BeanDefinition;

/**
 * @author zhp
 * @date 2023/9/12 17:19
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName){
        return getBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName,Object... args){
        return dogetBean(beanName,args);
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
