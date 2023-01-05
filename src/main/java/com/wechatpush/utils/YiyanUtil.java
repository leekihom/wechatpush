package com.wechatpush.utils;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author leezihong
 * @date 2023/1/4 17:50
 * @description
 */
@Component
@Slf4j
public class YiyanUtil {

    //@Value("${yiyan.api}")
    //private static String yiyan;

    public static String hitokoto(){

        String str = HttpUtil.get("https://v1.hitokoto.cn/?c=k&encode=text");
        log.info(str);
        return str;
    }
}
