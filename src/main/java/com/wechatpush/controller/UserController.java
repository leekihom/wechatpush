package com.wechatpush.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author leezihong
 * @Date 2023/1/5 21:28
 * @Version 1.0
 * @description TODO
 */

@Slf4j
@RestController
public class UserController {

    /*@PostMapping ("/catchMessage")
    public String catchMessage(HttpServletRequest request, HttpServletResponse response){

        String echostr = request.getParameter("echostr");


        try {
            Map<String, String> map = CheckUtil.parseXml(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return echostr;
    }*/
}
