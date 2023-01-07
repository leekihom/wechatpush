package com.wechatpush;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class WechatpushApplicationTests {
    @Autowired
    private JavaMailSender mailSender;

    @Test
    void contextLoads() {
    }

    @Test
    void sendmail(){
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom("2578527296@qq.com");
        //邮件接收人
        message.setTo("leelzh@foxmail.com");
        //邮件主题
        message.setSubject("测试");
        //邮件内容
        message.setText("每日推送测试");
        //发送邮件
        mailSender.send(message);
    }

}
