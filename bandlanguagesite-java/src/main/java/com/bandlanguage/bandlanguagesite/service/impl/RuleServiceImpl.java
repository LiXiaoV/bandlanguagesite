package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.mapper.RuleMapper;
import com.bandlanguage.bandlanguagesite.mapper.RuleUserMapper;
import com.bandlanguage.bandlanguagesite.mapper.SceneRuleMapper;
import com.bandlanguage.bandlanguagesite.model.entity.Rule;
import com.bandlanguage.bandlanguagesite.model.entity.RuleUser;
import com.bandlanguage.bandlanguagesite.model.entity.SceneRule;
import com.bandlanguage.bandlanguagesite.model.vo.RuleVo;
import com.bandlanguage.bandlanguagesite.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-31 11:47
 */
@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleMapper ruleMapper;

    @Autowired
    private SceneRuleMapper sceneRuleMapper;

    @Autowired
    private RuleUserMapper ruleUserMapper;

    @Override
    @Transactional
    public Boolean saveRule(RuleVo ruleVo) {
        Rule rule = Rule.builder().rule(ruleVo.getRule())
                .chineseName(ruleVo.getChineseName())
                .express(ruleVo.getExpress())
                .description(ruleVo.getDescription())
                .code(ruleVo.getCode())
                .creatorId(ruleVo.getUserId())
                .editorId(ruleVo.getEditorId())
                .updateTime(new Date()).build();
        int cnt = ruleMapper.insert(rule);
        if(cnt > 0){
            // 插入场景区与规则的关联
            SceneRule sceneRule = SceneRule.builder().sceneId(ruleVo.getSceneId())
                    .ruleId(rule.getRuleId()).build();
            int cnt1 = sceneRuleMapper.insert(sceneRule);

            // 插入用户与规则的关联
            RuleUser ruleUser = RuleUser.builder().ruleId(rule.getRuleId())
                    .userId(ruleVo.getUserId())
                    .updateTime(new Date()).build();
            int cnt2 = ruleUserMapper.insert(ruleUser);
            return cnt1 > 0 && cnt2 > 0;
        }
        return false;
    }

    @Override
    public List<RuleVo> getAllSimpleRulesBySceneId(Long sceneId) {
        return ruleMapper.getAllSimpleRulesBySceneId(sceneId);
    }

    @Override
    public List<RuleVo> getAllWholeRulesBySceneId(Long sceneId) {
        return ruleMapper.getAllWholeRulesBySceneId(sceneId);
    }
}
