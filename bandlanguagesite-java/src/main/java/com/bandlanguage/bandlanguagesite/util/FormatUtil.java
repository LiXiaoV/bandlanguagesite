package com.bandlanguage.bandlanguagesite.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 **/
public class FormatUtil {

    /**
     *时间类
     **/

    //比较date1和date2中哪个时间更早;如果date1更早,返回true；否则返回false
    public static Boolean DateStringBeforeCompare(String date1,String date2,String dateFormat) throws ParseException {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(dateFormat);

        Date dateA=simpleDateFormat.parse(date1);

        Date dateB=simpleDateFormat.parse(date2);

        return dateA.before(dateB);
    }

}
