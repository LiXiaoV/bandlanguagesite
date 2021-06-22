package com.bandlanguage.bandlanguagesite.remote.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface CoreRemoteService {

    //通过用户id获取
    JSONObject getBandIdByBandObjId(List<Long> bandObjIds) throws Exception;
}
