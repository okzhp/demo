package org.example.context;

import org.example.exception.BeansException;

/**
 * @author zhp
 * @date 2023/9/21 10:19
 **/
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
