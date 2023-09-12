package src.main.java.org.example.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhp
 * @date 2023/9/8 13:43
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleTon(String beanName) {
        return null;
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
