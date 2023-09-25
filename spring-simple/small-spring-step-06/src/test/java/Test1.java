import cn.hutool.core.io.IoUtil;
import org.example.beans.factory.DefaultListableBeanFactory;
import org.example.core.io.DefaultResourceLoader;
import org.example.core.io.Resource;
import org.example.beans.factory.xml.XmlBeanDefinitionReader;
import org.junit.jupiter.api.Test;
import test.UserService;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zhp
 * @date 2023/9/13 10:39
 **/
public class Test1 {

    @Test
    public void test_BeanFactory(){

        //1、直接读取xml，自动注册bean
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xml = new XmlBeanDefinitionReader(factory);
        xml.loadBeanDefinitions("classpath:Beans.xml");

        //3、获取实例
        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();


    }

    @Test
    public void test_LoadResource() throws IOException {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("src/main/resources/important.properties");
        System.out.println(IoUtil.readUtf8(resource.getInputStream()));
    }
    @Test
    public void test2() throws IOException {
        URL u = new URL("https://toutiao.io/posts/hot/7");

        System.out.println(u);
        System.out.println("文件类型："+u.getFile());
        System.out.println("使用的协议： " + u.getProtocol()); //获取URL里面的超文本协议
        URLConnection co = u.openConnection();
        InputStream is = co.getInputStream();


        byte[] bytes = new byte[1024];
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int len;
        while((len = is.read(bytes)) != -1){
            os.write(bytes,0,len);
        }
        os.close();

        System.out.println(new String(os.toByteArray()));

    }
}
