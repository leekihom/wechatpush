package com.wechatpush.service.Impl;

import com.wechatpush.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Author leezihong
 * @Date 2023/1/7 19:21
 * @Version 1.0
 * @description TODO
 */

@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.from}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(from);
        //邮件接收人
        message.setTo(to);
        //邮件主题
        message.setSubject(subject);
        //邮件内容
        message.setText(content);
        //发送邮件
        mailSender.send(message);
        log.info("邮件发送成功------------------------"+message);
    }
}
