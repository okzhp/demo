package org.example.support;

import org.example.io.DefaultResourceLoader;
import org.example.io.ResourceLoader;

/**
 * @author zhp
 * @date 2023/9/14 13:57
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry beanDefinitionRegistry;

    private final ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry){
        this(beanDefinitionRegistry,new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry,ResourceLoader resourceLoader){
        this.beanDefinitionRegistry = beanDefinitionRegistry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegister(){
        return beanDefinitionRegistry;
    }

    @Override
    public ResourceLoader getResourceLoader(){
        return resourceLoader;
    }
}
