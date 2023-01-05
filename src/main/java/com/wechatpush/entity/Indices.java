package com.wechatpush.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author leezihong
 * @date 2023/1/4 17:04
 * @description
 */
@Data
@AllArgsConstructor
public class Indices {
    //运动指数 1
    private String sport;

    //运动建议
    private String sporttext;

    //穿衣指数 3
    private String wear;

    //穿衣建议
    private String weartext;

    //防晒指数 16
    private String skin;

    //防晒建议
    private String skintext;
}
