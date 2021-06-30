package com.bandlanguage.bandlanguagesite.controller;

import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.cache.prefix.EnvironmentKey;
import com.bandlanguage.bandlanguagesite.constant.EnvironmentType;
import com.bandlanguage.bandlanguagesite.environment.EnvironmentManagement;
import com.bandlanguage.bandlanguagesite.remote.service.CoreRemoteService;
import com.bandlanguage.bandlanguagesite.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 **/
@Controller
@RestController
@RequestMapping("/environment")
public class EnvironmentController {

    @Autowired
    private IGlobalCache cache;

    @Autowired
    private CoreRemoteService coreRemoteService;

    @RequestMapping(value = "/initEnvironment",method = RequestMethod.GET)
    public Result initEnvironment(@RequestParam Long bandObjId) throws Exception{
        //获取bandId和organizationId
        List<Long> bandObjIds=new ArrayList<Long>();
        bandObjIds.add(bandObjId);
        Map<String, Object> bandByBandObjId = coreRemoteService.getBandByBandObjId(bandObjIds);

        Long bandId = Long.valueOf(bandByBandObjId.get("objID").toString());

        Long organizationId = Long.valueOf(bandByBandObjId.get("organizationID").toString());

        Map<String,Object> result=new HashMap<String, Object>();

        if(cache.get(EnvironmentKey.instance.getPrefix() +"organization"+organizationId)!=null){
            result.put("organizationEnvironment", cache.get(EnvironmentKey.instance.getPrefix()+"organization"+organizationId));

        }else{
            Map<String, Object> oEnvironment = EnvironmentManagement.getInstance().getEnvironment(organizationId, EnvironmentType.ORGANIZATION_ENVIRONMENT);
            result.put("organizationEnvironment",oEnvironment);
        }

        if(cache.get(EnvironmentKey.instance.getPrefix()+"band"+bandId)!=null){
            result.put("bandEnvironment",cache.get(EnvironmentKey.instance.getPrefix()+"band"+bandId));
//            System.out.println(cache.get(EnvironmentKey.instance.getPrefix()+"band"+bandId));
        }else{
            Map<String, Object> bEnvironment = EnvironmentManagement.getInstance().getEnvironment(bandId, EnvironmentType.BAND_ENVIRONMENT);
            result.put("bandEnvironment",bEnvironment);
        }

        System.out.println(result);

        return Result.success(result);
    }

    @RequestMapping(value = "/updateOrganizationEnvironment",method = RequestMethod.GET)
    public Result updateOrganizationEnvironment(@RequestParam Long organizationId) throws Exception{

        Map<String, Object> map = EnvironmentManagement.getInstance().updateEnvironment(organizationId, EnvironmentType.ORGANIZATION_ENVIRONMENT);

        return Result.success(map);
    }

    @RequestMapping(value = "/updateBandEnvironment",method = RequestMethod.GET)
    public Result updateBandEnvironment(@RequestParam Long bandId) throws Exception{

        Map<String, Object> map = EnvironmentManagement.getInstance().updateEnvironment(bandId, EnvironmentType.BAND_ENVIRONMENT);

        return Result.success(map);
    }

}
