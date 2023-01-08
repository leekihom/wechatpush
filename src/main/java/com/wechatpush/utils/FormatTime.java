package com.wechatpush.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;


public class FormatTime {

    public static String format(){
        SimpleDateFormat myFmt3 = new SimpleDateFormat("yyyy-MM-dd E", Locale.SIMPLIFIED_CHINESE);
        Date now = new Date();
        return myFmt3.format(now);
    }
}
