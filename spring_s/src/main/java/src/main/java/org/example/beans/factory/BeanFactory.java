package src.main.java.org.example.beans.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhp
 * @date 2023/9/8 10:01
 **/
public class BeanFactory {
    private Map<String, Object> beanMap = new HashMap<>();

    public void registerBean(String name,Object bean){
        beanMap.put(name,bean);
    }

    public Object getBean(String name){
        return beanMap.get(name);
    }
}
