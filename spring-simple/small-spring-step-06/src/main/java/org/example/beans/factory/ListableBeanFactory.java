package org.example.beans.factory;

import org.example.exception.BeansException;

import java.util.Map;

/**
 * @author zhp
 * @date 2023/9/21 09:51
 **/
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回bean实例
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> Map<String,T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有Bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
