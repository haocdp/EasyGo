package com.unicorn.easygo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by haoc_dp on 2017/6/28.
 */

public class DateUtil {
    private static String pattern = "yyyy-MM-dd";

    public static Date string2Date(String strDate) throws Exception{
        return "".equals(strDate) || strDate == null ?
                null :
                new SimpleDateFormat(pattern, Locale.CHINA).parse(strDate);
    }

    public static String date2String(Date date) throws Exception {
        return date == null ?
                null :
                new SimpleDateFormat(pattern, Locale.CHINA).format(date);
    }
}
