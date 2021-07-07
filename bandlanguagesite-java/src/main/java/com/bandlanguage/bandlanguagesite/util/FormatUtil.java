package com.bandlanguage.bandlanguagesite.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.exception.FormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //前端传来[{key:""，value:""}]数据时，处理并返回Map<String,Object>
    public static Map<String,Object> ObjectMap2Map(String objectMap) throws Exception{
        JSONArray array= JSON.parseArray(objectMap);
        Map<String,Object> map=new HashMap<String, Object>();
        for (int i = 0; i < array.size(); i++) {
            JSONObject item=array.getJSONObject(i);
            if(!item.containsKey("key")||!item.containsKey("value")){
                throw new FormatException();
            }
            map.put(item.get("key").toString(),item.get("value"));
        }
        return map;
    }

}
