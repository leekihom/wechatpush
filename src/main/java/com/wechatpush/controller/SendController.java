package com.wechatpush.controller;

import cn.hutool.core.date.ChineseDate;
import com.wechatpush.entity.Indices;
import com.wechatpush.entity.Weather;
import com.wechatpush.utils.FormatTime;
import com.wechatpush.utils.WeatherUtil;
import com.wechatpush.utils.YiyanUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author leezihong
 * @date 2023/1/4 12:34
 * @description
 */
@Component
@Slf4j
public class SendController {
    @Value("${wx.appID}")
    private String appID;
    @Value("${wx.appsecret}")
    private String appsecret;
    @Value("${wx.templateId}")
    private String templateId;

    @Autowired
    private WeatherUtil weatherUtil;

    @Autowired
    private YiyanUtil yiyanUtil;



    public void push(String openid){
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appID);
        wxStorage.setSecret(appsecret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        String today = FormatTime.format();

        ChineseDate chinese = new ChineseDate(new Date());
        //String chineseDate = "农历 "+chinese.toString();

        Weather weather = weatherUtil.getWeather();
        Indices indices = weatherUtil.getIndices();

        String yiyan = YiyanUtil.hitokoto();


        //2,循环推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openid)
                .templateId(templateId)
                .build();
        templateMessage.addData(new WxMpTemplateData("smile","\uD83D\uDE03","#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("today",today,"#4EEE94"));
        templateMessage.addData(new WxMpTemplateData("chineseDate",chinese.toString(),"#a0ee32"));
        templateMessage.addData(new WxMpTemplateData("city",weather.getCity()+"","#7A378B"));
        templateMessage.addData(new WxMpTemplateData("wendu",weather.getTemp()+"度"+"","#3aeede"));
        templateMessage.addData(new WxMpTemplateData("tiganwendu",weather.getFeelsLike()+"度"+"","#7B68EE"));
        templateMessage.addData(new WxMpTemplateData("weather",weather.getText()+"","#eea5e1"));
        templateMessage.addData(new WxMpTemplateData("windDir",weather.getWindDir()+"","#caee53"));
        templateMessage.addData(new WxMpTemplateData("humidity",weather.getHumidity()+"","#eed42e"));

        templateMessage.addData(new WxMpTemplateData("sport",indices.getSport()+"","#CD3278"));
        templateMessage.addData(new WxMpTemplateData("sporttext",indices.getSporttext(),"#14cd15"));

        templateMessage.addData(new WxMpTemplateData("wear",indices.getWear()+"","#4acdae"));
        templateMessage.addData(new WxMpTemplateData("weartext",indices.getWeartext(),"#16a4cd"));

        templateMessage.addData(new WxMpTemplateData("skin",indices.getSkin()+"","#757fcd"));
        templateMessage.addData(new WxMpTemplateData("skintext",indices.getSkintext(),"#93cd61"));

        templateMessage.addData(new WxMpTemplateData("yiyan",yiyan,"#FF8247"));
        try {
            log.info(templateMessage.toJson());
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

}