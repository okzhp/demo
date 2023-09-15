package org.example;

/**
 * @author zhp
 * @date 2023/9/8 10:38
 **/
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean(){
        return bean;
    }

}
