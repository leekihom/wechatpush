package com.wechatpush.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author leezihong
 * @date 2023/1/4 15:50
 * @description
 */
@Data
@AllArgsConstructor
@ToString
public class Weather {

    private String city;

    //天气
    private String text;

    //风向
    private String windDir;

    //温度
    private String temp;

    //体感温度
    private String feelsLike;

    //空气湿度
    private String humidity;

}
