package org.example.beans.factory.support;

/**
 * @author zhp
 * @date 2023/9/8 13:42
 * 单例注册表
 **/
public interface SingletonBeanRegistry {
    Object getSingleTon(String beanName);
}
