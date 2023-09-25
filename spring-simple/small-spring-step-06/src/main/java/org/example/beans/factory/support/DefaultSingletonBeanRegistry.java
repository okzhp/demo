package org.example.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhp
 * @date 2023/9/12 17:16
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String,Object> singletonMap = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonMap.get(beanName);
    }

    /**
     * `addSingleton` 方法之所以没有被定义在 `SingletonBeanRegistry` 接口中，而是放在 `DefaultSingletonBeanRegistry` 类中，是因为这个方法是框架的内部实现细节，而不是公共API的一部分。
     *
     * 接口 `SingletonBeanRegistry` 主要用于定义获取单例对象的方法，即 `getSingleton` 方法，这是一个公共的方法，供外部代码使用，以获取已注册的单例对象。
     *
     * 而 `addSingleton` 方法是用来向单例对象的注册表中添加新的单例对象的，这个操作通常由Spring框架的内部组件在bean初始化过程中进行。将 `addSingleton` 方法定义在接口中会暴露这个方法给外部使用者，但通常情况下，外部使用者不需要直接操作单例对象的注册过程，因为Spring框架会自动处理这个过程。
     *
     * 将 `addSingleton` 方法放在类中，可以将这个方法限制在框架的内部，提供更好的封装和控制，同时避免不必要的外部调用，从而确保单例对象的注册过程受到框架的管理和保护。
     *
     * 总之，`addSingleton` 方法之所以不在接口中定义，是因为它是Spring框架的内部实现细节，而不是公共的API，而接口 `SingletonBeanRegistry` 主要用于定义公共的获取单例对象的方法。这种设计符合封装和模块化的原则，使得框架的内部实现细节与外部API清晰分离。
     *
     */
    protected void addSingleton(String beanName,Object singletonObject){
        singletonMap.put(beanName,singletonObject);
    }
}
