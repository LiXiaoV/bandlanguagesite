package com.bandlanguage.bandlanguagesite.service;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.impl.bl.FunctionalIntegrationBLServiceImpl;
import com.bandlanguage.bandlanguagesite.service.impl.bl.OrganizationManageBLServiceImpl;
import com.bandlanguage.bandlanguagesite.service.impl.bl.PapersAnalysisBLServiceImpl;
import org.springframework.stereotype.Component;

/**
 * @author xiaov
 * @since 2021-06-15 10:42
 */
@Component
public class BLFactory {

    /**
     * 根据场景区ID获得帮语核心的实现类
     *
     * @param sceneId 场景区ID
     * @return 帮语核心的实现类
     */
    public BLService getBLService(Long sceneId) {
        if(null == sceneId) return null;
        if(1 == sceneId) return new OrganizationManageBLServiceImpl();
        if(2 == sceneId) return new FunctionalIntegrationBLServiceImpl();
        if(3 == sceneId) return new PapersAnalysisBLServiceImpl();
        throw new GlobalException(ResultCode.BL_SERVICE_NOT_EXIST);
    }
}
