package com.wechatpush.service;

/**
 * @Author leezihong
 * @Date 2023/1/7 19:19
 * @Version 1.0
 * @description TODO
 */
public interface MailService {

    void sendSimpleMail(String to,String subject,String content);

}
