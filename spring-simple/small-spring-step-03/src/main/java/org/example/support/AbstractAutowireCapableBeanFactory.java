package org.example.support;

import org.example.factory.BeanDefinition;
import java.lang.reflect.Constructor;

/**
 * @author zhp
 * @date 2023/9/12 17:45
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

//    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object... args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName,beanDefinition,args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object createBeanInstance(String beanName,BeanDefinition beanDefinition,Object... args){
        Class clazz = beanDefinition.getBeanClass();
        Constructor[] constructors = clazz.getDeclaredConstructors();
        Constructor use = null;
        for (Constructor constructor : constructors) {
            if (args != null &&constructor.getParameterTypes().length == args.length){
                use = constructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,use,args);
    }

    public InstantiationStrategy getInstantiationStrategy(){
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy){
        this.instantiationStrategy = instantiationStrategy;
    }
}
