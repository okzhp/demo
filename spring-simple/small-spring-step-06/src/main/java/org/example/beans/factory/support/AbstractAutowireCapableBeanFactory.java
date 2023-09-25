package org.example.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.example.beans.factory.BeanDefinition;
import org.example.beans.factory.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author zhp
 * @date 2023/9/12 17:45
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

//    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) {
        Object bean = null;
//        try {
            bean = createBeanInstance(beanName,beanDefinition,args);
            //填充bean的属性
            applyPropertyValues(beanName,bean,beanDefinition);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
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

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue pv : propertyValues.getPropertyValues()) {
            String name = pv.getName();
            Object value = pv.getValue();

            if (value instanceof BeanReference){
                BeanReference value1 = (BeanReference) value;
                value = getBean(value1.getBeanName());
            }
            // 属性填充
            BeanUtil.setFieldValue(bean, name, value);
        }
    }

}
