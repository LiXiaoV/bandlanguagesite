package com.bandlanguage.bandlanguagesite.service;

import com.bandlanguage.bandlanguagesite.model.vo.RuleVo;

import java.util.List;

/**
 * 规则的服务类
 *
 * @author xiaov
 * @since 2021-05-31 11:46
 */
public interface RuleService {

    /**
     * 保存规则
     *
     * @param ruleVo 规则的视图类
     * @return 是否成功
     */
    Boolean saveRule(RuleVo ruleVo);

    /**
     * 通过场景区获取所有规则--简单信息
     *
     * @param sceneId 场景区ID
     * @return RuleVo对象数组
     */
    List<RuleVo> getAllSimpleRulesBySceneId(Long sceneId);

    /**
     * 通过场景区获取所有规则--完整信息
     *
     * @param sceneId 场景区ID
     * @return RuleVo对象数组
     */
    List<RuleVo> getAllWholeRulesBySceneId(Long sceneId);
}
