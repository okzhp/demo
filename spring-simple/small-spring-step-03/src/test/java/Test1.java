import org.example.factory.BeanDefinition;
import org.example.factory.DefaultListableBeanFactory;
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
        BeanDefinition userServiceDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registry("userService",userServiceDefinition);

        //3、获取实例
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService","张三");
        userService.queryUserInfo();


    }
}
