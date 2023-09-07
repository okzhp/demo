package com.example.demo.test;

import com.example.demo.DemoApplication;
import com.example.demo.service.MailSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhp
 * @date 2023/5/19 10:44
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TTest {

    @Autowired
    private MailSendService mailSendService;

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
}
