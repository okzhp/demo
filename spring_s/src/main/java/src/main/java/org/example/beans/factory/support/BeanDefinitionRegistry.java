package src.main.java.org.example.beans.factory.support;

import org.example.beans.factory.config.BeanDefinition;

/**
 * @author zhp
 * @date 2023/9/8 10:34
 **/
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
