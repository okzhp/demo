package org.example.beans.factory.support;

import org.example.beans.factory.BeanDefinition;
import org.springframework.beans.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK实例化
 * @author zhp
 * @date 2023/9/13 14:04
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (constructor != null){
                return clazz.getConstructor(constructor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getConstructor().newInstance();
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
