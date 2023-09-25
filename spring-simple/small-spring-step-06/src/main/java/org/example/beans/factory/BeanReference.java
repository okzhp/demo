package org.example.beans.factory;

/**
 * @author zhp
 * @date 2023/9/13 17:15
 **/
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}