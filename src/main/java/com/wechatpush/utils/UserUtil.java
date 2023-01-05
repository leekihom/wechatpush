package com.wechatpush.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author leezihong
 * @date 2023/1/4 17:54
 * @description
 */
@Component
@Slf4j
public class UserUtil {

    @Value("${wx.appID}")
    private String appID;

    @Value("${wx.appsecret}")
    private String appsecret;

    @Value("${wx.userListApi}")
    private String userListApi;

    @Value("${wx.userInfoApi}")
    private String userInfoApi;

    @Autowired
    private GetAccessToken getAccessToken;

    public List<String> getAllUser(String access_token){

        HashMap<String, Object> param = new HashMap<>();
        param.put("access_token",access_token);

        String response = HttpUtil.get(userListApi, param);

        JSONObject jsonObject = JSONUtil.parseObj(response);
        JSONObject openidObj = (JSONObject) jsonObject.get("data");
        List<String> openid = (List<String>) openidObj.get("openid");

        log.info(openid.toString());

        return openid;

    }
    public List<String> getUserInfo(String access_token,String openid){

        HashMap<String, Object> param = new HashMap<>();
        param.put("access_token",access_token);
        param.put("openid",openid);
        param.put("lang","zh_CN");

        String response = HttpUtil.get(userInfoApi, param);

        JSONObject jsonObject = JSONUtil.parseObj(response);

        log.info(openid.toString());

        return null;

    }
}
