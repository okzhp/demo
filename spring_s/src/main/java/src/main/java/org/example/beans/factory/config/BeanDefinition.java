package src.main.java.org.example.beans.factory.config;

/**
 * @author zhp
 * @date 2023/9/8 10:38
 **/
public class BeanDefinition {
    private Class beanClass;

    private BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
    }

    public Class getBeanClass(){
        return beanClass;
    }

    public void setBeanClass(Class beanClass){
        this.beanClass = beanClass;
    }
}
