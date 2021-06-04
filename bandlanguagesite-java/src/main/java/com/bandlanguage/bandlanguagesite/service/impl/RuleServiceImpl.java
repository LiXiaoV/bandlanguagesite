package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.RuleMapper;
import com.bandlanguage.bandlanguagesite.mapper.RuleUserMapper;
import com.bandlanguage.bandlanguagesite.mapper.SceneRuleMapper;
import com.bandlanguage.bandlanguagesite.mapper.UserMapper;
import com.bandlanguage.bandlanguagesite.model.entity.*;
import com.bandlanguage.bandlanguagesite.model.vo.RuleVo;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.RuleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Boolean saveRule(RuleVo ruleVo) {
        Rule rule = Rule.builder().rule(ruleVo.getRule())
                .chineseName(ruleVo.getChineseName())
                .express(ruleVo.getExpress())
                .description(ruleVo.getDescription())
                .code(ruleVo.getCode())
                .creatorId(ruleVo.getUserId())
                .editorId(ruleVo.getUserId())
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

    @Override
    public RuleVo getRuleDetailById(Long ruleId) {
        Rule rule = ruleMapper.selectById(ruleId);
        if (rule == null)
            throw new GlobalException(ResultCode.SELECT_RULE_NOT_EXIST);
        User creator = userMapper.selectById(rule.getCreatorId());
        User editor = userMapper.selectById(rule.getEditorId());
        return RuleVo.builder().ruleId(rule.getRuleId())
                .rule(rule.getRule())
                .chineseName(rule.getChineseName())
                .express(rule.getExpress())
                .description(rule.getDescription())
                .code(rule.getCode())
                .creatorId(rule.getCreatorId())
                .creatorUsername(creator.getUsername())
                .creatorNickname(creator.getNickname())
                .editorId(rule.getEditorId())
                .editorUsername(editor.getUsername())
                .editorNickname(editor.getNickname())
                .updateTime(rule.getUpdateTime())
                .status(rule.getStatus()).build();
    }

    @Override
    @Transactional
    public Boolean editRule(RuleVo ruleVo) {
        Rule rule = Rule.builder().ruleId(ruleVo.getRuleId())
                .rule(ruleVo.getRule())
                .chineseName(ruleVo.getChineseName())
                .express(ruleVo.getExpress())
                .description(ruleVo.getDescription())
                .code(ruleVo.getCode())
                .editorId(ruleVo.getUserId())
                .updateTime(new Date()).build();
        int cnt = ruleMapper.updateById(rule);
        if(cnt <= 0)
            throw new GlobalException(ResultCode.EDIT_RULE_FAIL);

        // 查询此用户是否修改或创建过这个规则，如果是，则跟新时间，如果不是，则插入记录
        QueryWrapper<RuleUser> ruleUserQueryWrapper = new QueryWrapper<>();
        ruleUserQueryWrapper.eq("user_id",ruleVo.getUserId());
        ruleUserQueryWrapper.eq("rule_id",ruleVo.getRuleId());
        RuleUser ruleUser = ruleUserMapper.selectOne(ruleUserQueryWrapper);
        int cnt1;
        if(ruleUser != null){
            ruleUser.setUpdateTime(new Date());
            cnt1 = ruleUserMapper.updateById(ruleUser);
        }else {
            RuleUser insertRuleUser = RuleUser.builder().ruleId(ruleVo.getRuleId())
                    .userId(ruleVo.getUserId())
                    .updateTime(new Date()).build();
            cnt1 = ruleUserMapper.insert(insertRuleUser);
        }
        return cnt1 > 0;
    }
}
