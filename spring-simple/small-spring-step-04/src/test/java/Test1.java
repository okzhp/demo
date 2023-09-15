import org.example.factory.BeanDefinition;
import org.example.factory.BeanReference;
import org.example.factory.DefaultListableBeanFactory;
import org.example.support.PropertyValue;
import org.example.support.PropertyValues;
import org.junit.jupiter.api.Test;

/**
 * @author zhp
 * @date 2023/9/13 10:39
 **/
public class Test1 {

    @Test
    public void test_BeanFactory(){
        //1、初始化工厂
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();


        //2、向工厂注册类
        BeanDefinition userDaoDefinition = new BeanDefinition(UserDao.class,null);
        defaultListableBeanFactory.registry("userDao",userDaoDefinition);

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10002"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        BeanDefinition userServiceDefinition = new BeanDefinition(UserService.class,propertyValues);
        defaultListableBeanFactory.registry("userService",userServiceDefinition);

        //3、获取实例
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();


    }
}
