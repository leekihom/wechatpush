package com.wechatpush.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class FormatTime {

    public static String format(){
        SimpleDateFormat myFmt3 = new SimpleDateFormat("yyyy-MM-dd E");
        Date now = new Date();
        return myFmt3.format(now);
    }
}
