import org.example.BeanDefinition;
import org.example.BeanFactory;
import org.junit.jupiter.api.Test;

/**
 * @author zhp
 * @date 2023/9/12 16:20
 **/
public class Testt{


    @Test
    public void testBeanFactory(){
        //1、初始化beanFactory
        BeanFactory beanFactory = new BeanFactory();

        //2、向beanFactory注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //3、获取bean
        UserService userService = (UserService) beanFactory.getBeanDefinitionMap("userService");
        userService.queryUserInfo();
    }
}
