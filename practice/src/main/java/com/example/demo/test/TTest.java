package com.example.demo.test;

import com.example.demo.DemoApplication;
import com.example.demo.service.MailSendService;
import okhttp3.OkHttp;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhp
 * @date 2023/5/19 10:44
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TTest {

    @Autowired
    private MailSendService mailSendService;

    private static final Logger logger = LoggerFactory.getLogger(TTest.class);

    @Test
    public void sendMailTest(){
        String to = "jackson.zhpp@gmail.com";
        String subject = "测试主题";
        String content = "你好，这是我用程序发送的第一条邮件!";
        mailSendService.sendSimpleMail(to,subject,content);
        System.out.println("发送完毕，请检查邮箱!");
    }

    @Test
    public void sendMailHtmlTest(){
        String to = "3206665058@qq.com";
        String subject = "测试主题2";
        String content = "<html><body><h3><font color=\"red\">" + "大家好，这是springboot发送的HTML邮件" + "</font></h3></body></html>";
        mailSendService.sendHtmlMail(to,subject,content);
        System.out.println("html邮件发送完毕，请检查邮箱!");
    }

    @Test
    public void checkAppointment() throws InterruptedException, IOException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = httpClientBuilder.build();
        boolean falg = true;
        while (falg){
            long l = randomTime(3, 5);
            logger.info("休眠时间：{}毫秒",l);
            Thread.sleep(l);
            HttpGet httpGet = new HttpGet("https://api.dfssclub.cn/api/v2/CarAppt/Dfss/AvailablePlanGrpByDate?trainingBaseId=01&vehicleNum=F");
            httpGet.setHeader("ApiKey","708522cecbed4a0eb2dc3cff8afd6512");
            httpGet.setHeader("ClientVersionCode","139");
            httpGet.setHeader("DeviceSystem","android 13");
            httpGet.setHeader("Noncestr","582359");
            httpGet.setHeader("DeviceId","7892fe8a42e44756951b9d03977f8dd9");
            httpGet.setHeader("ApiChecksum","313763889ed3992b0f0ac9de12dc1022");
            httpGet.setHeader("ClientVersion","4.2.1");
            httpGet.setHeader("TimeStamp",String.valueOf(System.currentTimeMillis()/1000));
            httpGet.setHeader("PushClientId","");

            httpGet.setHeader("AppOwnerId","1");
            httpGet.setHeader("AuthToken","f5b1957b3b794f52af3515525372a6cc");
            httpGet.setHeader("SchoolId","1");
            httpGet.setHeader("User-Agent","Dalvik/2.1.0 (Linux; U; Android 13; PHB110 Build/TP1A.220905.001)");
            httpGet.setHeader("Host","api.dfssclub.cn");
//            RequestConfig config = RequestConfig.custom().set
//            httpGet.setConfig(config);
            CloseableHttpResponse response = client.execute(httpGet);
            InputStream content = response.getEntity().getContent();
            String resText = null;
            if (content != null){
                String line = null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
                StringBuilder sb = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }
                resText = sb.toString();
            }
            logger.info(resText);
        }

    }

    /**
     * 获取指定范围内的随机时间戳
     * @return
     */
    private long randomTime(int start,int end){
        Random random = new Random();
        return (long) (start + random.nextInt(end - start))*1000;
    }
}
