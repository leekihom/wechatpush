package com.wechatpush.controller;


import com.wechatpush.utils.GetAccessToken;
import com.wechatpush.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author leezihong
 * @date 2023/1/4 15:43
 * @description
 */
@Component
@Slf4j
public class ScheduledPush {

    @Autowired
    private  SendController sendController;

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private GetAccessToken getAccessToken;

    @Scheduled(cron = "${TimerTask.cron}")
    public void push(){
        List<String> openids = userUtil.getAllUser(getAccessToken.getToken());
        openids.stream().forEach(System.out::println);
        openids.stream().forEach(openid -> sendController.push(openid));
    }
}
