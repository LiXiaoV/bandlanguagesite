package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.*;
import com.bandlanguage.bandlanguagesite.model.entity.*;
import com.bandlanguage.bandlanguagesite.model.vo.RuleVo;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.RuleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    @Autowired
    private WordRuleMapper wordRuleMapper;

    @Autowired
    private SentenceRuleMapper sentenceRuleMapper;

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
        if(cnt <= 0)
            throw new GlobalException(ResultCode.SAVE_RULE_FAIL);

        // 插入场景区与规则的关联
        SceneRule sceneRule = SceneRule.builder().sceneId(ruleVo.getSceneId())
                .ruleId(rule.getRuleId()).build();
        int cnt1 = sceneRuleMapper.insert(sceneRule);
        if(cnt1 <= 0)
            throw new GlobalException(ResultCode.SAVE_SCENE_RULE_FAIL);

        // 插入用户与规则的关联
        RuleUser ruleUser = RuleUser.builder().ruleId(rule.getRuleId())
                .userId(ruleVo.getUserId())
                .updateTime(new Date()).build();
        int cnt2 = ruleUserMapper.insert(ruleUser);
        if(cnt2 <= 0)
            throw new GlobalException(ResultCode.SAVE_RULE_USER_FAIL);

        // 插入规则与词汇句型的关联
        if(ruleVo.getType() == 1){
            // 插入规则与词汇的关联
            WordRule wordRule = WordRule.builder().wordId(ruleVo.getItemId())
                    .ruleId(rule.getRuleId()).build();
            int cnt3 = wordRuleMapper.insert(wordRule);
            if(cnt3 <= 0)
                throw new GlobalException(ResultCode.SAVE_WORD_RULE_FAIL);
        }else if(ruleVo.getType() == 2){
            // 插入规则与句型的关联
            SentenceRule sentenceRule = SentenceRule.builder().sentenceId(ruleVo.getItemId())
                    .ruleId(rule.getRuleId()).build();
            int cnt4 = sentenceRuleMapper.insert(sentenceRule);
            if(cnt4 <= 0)
                throw new GlobalException(ResultCode.SAVE_SENTENCE_RULE_FAIL);
        }
        return true;
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
        // 更新规则信息
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
            throw new GlobalException(ResultCode.UPDATE_RULE_FAIL);

        // 查询此用户是否修改或创建过这个规则，如果是，则跟新时间，如果不是，则插入记录
        QueryWrapper<RuleUser> ruleUserQueryWrapper = new QueryWrapper<>();
        ruleUserQueryWrapper.eq("user_id",ruleVo.getUserId());
        ruleUserQueryWrapper.eq("rule_id",ruleVo.getRuleId());
        RuleUser ruleUser = ruleUserMapper.selectOne(ruleUserQueryWrapper);
        int cnt1;
        if(ruleUser != null){
            ruleUser.setUpdateTime(new Date());
            cnt1 = ruleUserMapper.updateById(ruleUser);
            if(cnt1 <= 0)
                throw new GlobalException(ResultCode.UPDATE_RULE_USER_FAIL);
        }else {
            RuleUser insertRuleUser = RuleUser.builder().ruleId(ruleVo.getRuleId())
                    .userId(ruleVo.getUserId())
                    .updateTime(new Date()).build();
            cnt1 = ruleUserMapper.insert(insertRuleUser);
            if(cnt1 <= 0)
                throw new GlobalException(ResultCode.SAVE_RULE_USER_FAIL);
        }

        // 查询该词汇或句型是否与这个规则关联，如果没有关联，则关联，如果已经关联，则不用做处理
        if(ruleVo.getType() == 1){
            // 查看规则与词汇是否有关联，没有就插入
            QueryWrapper<WordRule> wordRuleQueryWrapper = new QueryWrapper<>();
            wordRuleQueryWrapper.eq("word_id",ruleVo.getItemId());
            wordRuleQueryWrapper.eq("rule_id",ruleVo.getRuleId());
            WordRule wordRule = wordRuleMapper.selectOne(wordRuleQueryWrapper);
            if(wordRule == null){
                WordRule insertWordRule = WordRule.builder().wordId(ruleVo.getItemId())
                        .ruleId(rule.getRuleId()).build();
                int cnt2 = wordRuleMapper.insert(insertWordRule);
                if(cnt2 <= 0)
                    throw new GlobalException(ResultCode.SAVE_WORD_RULE_FAIL);
            }else if(wordRule.getStatus() == 0){    // 已删除就恢复
                wordRule.setStatus(1);
                int updateCnt = wordRuleMapper.updateById(wordRule);
                if(updateCnt <= 0)
                    throw new GlobalException(ResultCode.UPDATE_WORD_RULE_FAIL);
            }
        }else if(ruleVo.getType() == 2){
            // 查看规则与句型是否有关联，没有就插入
            QueryWrapper<SentenceRule> sentenceRuleQueryWrapper = new QueryWrapper<>();
            sentenceRuleQueryWrapper.eq("sentence_id",ruleVo.getItemId());
            sentenceRuleQueryWrapper.eq("rule_id",ruleVo.getRuleId());
            SentenceRule sentenceRule = sentenceRuleMapper.selectOne(sentenceRuleQueryWrapper);
            if(sentenceRule == null){
                SentenceRule insertSentenceRule = SentenceRule.builder().sentenceId(ruleVo.getItemId())
                        .ruleId(rule.getRuleId()).build();
                int cnt3 = sentenceRuleMapper.insert(insertSentenceRule);
                if(cnt3 <= 0)
                    throw new GlobalException(ResultCode.SAVE_SENTENCE_RULE_FAIL);
            }else if(sentenceRule.getStatus() == 0){    // 已删除就恢复
                sentenceRule.setStatus(1);
                int updateCnt = sentenceRuleMapper.updateById(sentenceRule);
                if(updateCnt <= 0)
                    throw new GlobalException(ResultCode.UPDATE_SENTENCE_RULE_FAIL);
            }
        }
        return true;
    }

    @Override
    public List<RuleVo> getWordAssociatedRulesByWordId(Long wordId) {
        return ruleMapper.getWordAssociatedRulesByWordId(wordId);
    }

    @Override
    public List<RuleVo> getSentenceAssociatedRulesBySentenceId(Long sentenceId) {
        return ruleMapper.getSentenceAssociatedRulesBySentenceId(sentenceId);
    }

    @Override
    @Transactional
    public Boolean deleteRuleOfAssociate(RuleVo ruleVo) {
        // 先在rule里面把修改者改了
        Rule rule = Rule.builder().ruleId(ruleVo.getRuleId())
                .editorId(ruleVo.getEditorId())
                .updateTime(new Date()).build();
        int updateCnt = ruleMapper.updateById(rule);
        if(updateCnt <= 0)
            throw new GlobalException(ResultCode.UPDATE_RULE_FAIL);

        // 修改规则-词汇或句型表的status
        if(ruleVo.getType() == 1){
            // 规则与词汇
            UpdateWrapper<WordRule> wordRuleUpdateWrapper = new UpdateWrapper<>();
            wordRuleUpdateWrapper.eq("word_id",ruleVo.getItemId())
                    .eq("rule_id",ruleVo.getRuleId()).set("status",0);
            int deleteCnt = wordRuleMapper.update(null, wordRuleUpdateWrapper);
            if(deleteCnt <= 0)
                throw new GlobalException(ResultCode.DELETE_WORD_RULE_FAIL);
        }else if(ruleVo.getType() == 2){
            // 规则与句型
            UpdateWrapper<SentenceRule> sentenceRuleUpdateWrapper = new UpdateWrapper<>();
            sentenceRuleUpdateWrapper.eq("sentence_id",ruleVo.getItemId())
                    .eq("rule_id",ruleVo.getRuleId()).set("status",0);
            int deleteCnt = sentenceRuleMapper.update(null, sentenceRuleUpdateWrapper);
            if(deleteCnt <= 0)
                throw new GlobalException(ResultCode.DELETE_SENTENCE_RULE_FAIL);
        }
        return true;
    }
}
