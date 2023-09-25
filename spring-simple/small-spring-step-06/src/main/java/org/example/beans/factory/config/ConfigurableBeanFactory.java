package org.example.beans.factory.config;

import org.example.beans.factory.HierarchicalBeanFactory;
import org.example.beans.factory.support.SingletonBeanRegistry;

/**
 * @author zhp
 * @date 2023/9/21 17:15
 **/
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
