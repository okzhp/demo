package org.example.context.support;

import org.example.beans.factory.ConfigurableListableBeanFactory;
import org.example.beans.factory.DefaultListableBeanFactory;
import org.example.exception.BeansException;

/**
 * @author zhp
 * @date 2023/9/21 17:46
 **/
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
    }

    protected DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
