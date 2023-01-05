package com.wechatpush.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class GetAccessToken {
    @Value("${wx.appID}")
    private String appID;

    @Value("${wx.appsecret}")
    private String appsecret;

    @Value("${wx.tokenApi}")
    private String tokenApi;

    public String getToken(){
        HashMap<String, Object> param = new HashMap<>();
        param.put("grant_type","client_credential");
        param.put("appid",appID);
        param.put("secret",appsecret);
        String response = HttpUtil.get(tokenApi, param);
        JSONObject jsonObject = JSONUtil.parseObj(response);
        //{"access_token":"ACCESS_TOKEN","expires_in":7200}
        return jsonObject.get("access_token").toString();
    }

}
