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

    /**
     * 根据ID查询rule
     *
     * @param ruleId 规则Id
     * @return 规则的视图类
     */
    RuleVo getRuleDetailById(Long ruleId);

    /**
     * 修改规则
     *
     * @param ruleVo 规则的视图类
     * @return 是否修改成功
     */
    Boolean editRule(RuleVo ruleVo);

    /**
     * 获得与某个词汇关联的所有规则
     *
     * @param wordId 词汇ID
     * @return 规则的视图类数组
     */
    List<RuleVo> getWordAssociatedRulesByWordId(Long wordId);

    /**
     * 获得与某个句型关联的所有规则
     *
     * @param sentenceId 句型ID
     * @return 规则的视图类数组
     */
    List<RuleVo> getSentenceAssociatedRulesBySentenceId(Long sentenceId);

    /**
     * 删除规则与词汇或句型的联系
     *
     * @param ruleVo 规则的视图类
     * @return 删除是否成功
     */
    Boolean deleteRuleOfAssociate(RuleVo ruleVo);

    /**
     * 删除规则
     *
     * @param ruleVo 规则的视图类，，主要传规则ID和删除者的用户ID
     * @return 删除规则是否成功
     */
    Boolean deleteRule(RuleVo ruleVo);
}
