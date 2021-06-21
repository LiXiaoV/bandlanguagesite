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
        int insertRuleCount = ruleMapper.insert(rule);
        if (insertRuleCount <= 0)
            throw new GlobalException(ResultCode.SAVE_RULE_FAIL);

        // 插入场景区与规则的关联
        SceneRule sceneRule = SceneRule.builder().sceneId(ruleVo.getSceneId())
                .ruleId(rule.getRuleId()).build();
        int insertSceneRuleCount = sceneRuleMapper.insert(sceneRule);
        if (insertSceneRuleCount <= 0)
            throw new GlobalException(ResultCode.SAVE_SCENE_RULE_FAIL);

        // 插入用户与规则的关联
        RuleUser ruleUser = RuleUser.builder().ruleId(rule.getRuleId())
                .userId(ruleVo.getUserId())
                .updateTime(new Date()).build();
        int insertRuleUserCount = ruleUserMapper.insert(ruleUser);
        if (insertRuleUserCount <= 0)
            throw new GlobalException(ResultCode.SAVE_RULE_USER_FAIL);

        // 在词汇或句型开发窗口里面添加规则
        // 插入规则与词汇句型的关联
        if (ruleVo.getType() == 1) {    // 词汇
            // 插入规则与词汇的关联
            WordRule wordRule = WordRule.builder().wordId(ruleVo.getItemId())
                    .ruleId(rule.getRuleId()).build();
            int insertWordRuleCount = wordRuleMapper.insert(wordRule);
            if (insertWordRuleCount <= 0)
                throw new GlobalException(ResultCode.SAVE_WORD_RULE_FAIL);
        } else if (ruleVo.getType() == 2) { // 句型
            // 插入规则与句型的关联
            SentenceRule sentenceRule = SentenceRule.builder().sentenceId(ruleVo.getItemId())
                    .ruleId(rule.getRuleId()).build();
            int insertSentenceRuleCount = sentenceRuleMapper.insert(sentenceRule);
            if (insertSentenceRuleCount <= 0)
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
        int updateRuleCount = ruleMapper.updateById(rule);
        if (updateRuleCount <= 0)
            throw new GlobalException(ResultCode.UPDATE_RULE_FAIL);

        // 查询此用户是否修改或创建过这个规则，如果是，则更新时间，如果不是，则插入记录
        QueryWrapper<RuleUser> ruleUserQueryWrapper = new QueryWrapper<>();
        ruleUserQueryWrapper.eq("user_id", ruleVo.getUserId());
        ruleUserQueryWrapper.eq("rule_id", ruleVo.getRuleId());
        RuleUser ruleUser = ruleUserMapper.selectOne(ruleUserQueryWrapper);
        if (ruleUser != null) {
            ruleUser.setUpdateTime(new Date());
            int updateRuleUserCount = ruleUserMapper.updateById(ruleUser);
            if (updateRuleUserCount <= 0)
                throw new GlobalException(ResultCode.UPDATE_RULE_USER_FAIL);
        } else {
            RuleUser insertRuleUser = RuleUser.builder().ruleId(ruleVo.getRuleId())
                    .userId(ruleVo.getUserId())
                    .updateTime(new Date()).build();
            int insertRuleUserCount = ruleUserMapper.insert(insertRuleUser);
            if (insertRuleUserCount <= 0)
                throw new GlobalException(ResultCode.SAVE_RULE_USER_FAIL);
        }

        // 在词汇或句型开发窗口里面修改规则
        // 查询该词汇或句型是否与这个规则关联，如果没有关联，则关联，如果已经关联，则不用做处理
        if (ruleVo.getType() == 1) {    // 词汇
            // 查看规则与词汇是否有关联，没有就插入
            QueryWrapper<WordRule> wordRuleQueryWrapper = new QueryWrapper<>();
            wordRuleQueryWrapper.eq("word_id", ruleVo.getItemId());
            wordRuleQueryWrapper.eq("rule_id", ruleVo.getRuleId());
            WordRule wordRule = wordRuleMapper.selectOne(wordRuleQueryWrapper);
            if (wordRule == null) {
                WordRule insertWordRule = WordRule.builder().wordId(ruleVo.getItemId())
                        .ruleId(rule.getRuleId()).build();
                int insertWordRuleCount = wordRuleMapper.insert(insertWordRule);
                if (insertWordRuleCount <= 0)
                    throw new GlobalException(ResultCode.SAVE_WORD_RULE_FAIL);
            } else if (wordRule.getStatus() == 0) {    // 已删除就恢复
                wordRule.setStatus(1);
                int updateWordRuleCnt = wordRuleMapper.updateById(wordRule);
                if (updateWordRuleCnt <= 0)
                    throw new GlobalException(ResultCode.UPDATE_WORD_RULE_FAIL);
            }
        } else if (ruleVo.getType() == 2) { // 句型
            // 查看规则与句型是否有关联，没有就插入
            QueryWrapper<SentenceRule> sentenceRuleQueryWrapper = new QueryWrapper<>();
            sentenceRuleQueryWrapper.eq("sentence_id", ruleVo.getItemId());
            sentenceRuleQueryWrapper.eq("rule_id", ruleVo.getRuleId());
            SentenceRule sentenceRule = sentenceRuleMapper.selectOne(sentenceRuleQueryWrapper);
            if (sentenceRule == null) {
                SentenceRule insertSentenceRule = SentenceRule.builder().sentenceId(ruleVo.getItemId())
                        .ruleId(rule.getRuleId()).build();
                int insertSentenceRuleCount = sentenceRuleMapper.insert(insertSentenceRule);
                if (insertSentenceRuleCount <= 0)
                    throw new GlobalException(ResultCode.SAVE_SENTENCE_RULE_FAIL);
            } else if (sentenceRule.getStatus() == 0) {    // 已删除就恢复
                sentenceRule.setStatus(1);
                int updateSentenceRuleCnt = sentenceRuleMapper.updateById(sentenceRule);
                if (updateSentenceRuleCnt <= 0)
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
        int updateRuleCnt = ruleMapper.updateById(rule);
        if (updateRuleCnt <= 0)
            throw new GlobalException(ResultCode.UPDATE_RULE_FAIL);

        // 修改规则-词汇或句型表的status
        if (ruleVo.getType() == 1) {    // 词汇
            // 规则与词汇
            UpdateWrapper<WordRule> wordRuleUpdateWrapper = new UpdateWrapper<>();
            wordRuleUpdateWrapper.eq("word_id", ruleVo.getItemId())
                    .eq("rule_id", ruleVo.getRuleId()).set("status", 0);
            int deleteWordRuleCnt = wordRuleMapper.update(null, wordRuleUpdateWrapper);
            if (deleteWordRuleCnt <= 0)
                throw new GlobalException(ResultCode.DELETE_WORD_RULE_FAIL);
        } else if (ruleVo.getType() == 2) { // 句型
            // 规则与句型
            UpdateWrapper<SentenceRule> sentenceRuleUpdateWrapper = new UpdateWrapper<>();
            sentenceRuleUpdateWrapper.eq("sentence_id", ruleVo.getItemId())
                    .eq("rule_id", ruleVo.getRuleId()).set("status", 0);
            int deleteSentenceRuleCnt = sentenceRuleMapper.update(null, sentenceRuleUpdateWrapper);
            if (deleteSentenceRuleCnt <= 0)
                throw new GlobalException(ResultCode.DELETE_SENTENCE_RULE_FAIL);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteRule(RuleVo ruleVo) {
        // 1. 根据规则ID查找节点要删除的规则是否存在
        if (ruleVo.getRuleId() <= 0 || ruleVo.getRuleId() == null)
            throw new GlobalException(ResultCode.DELETE_RULE_NOT_EXIST);
        Rule rule = ruleMapper.selectById(ruleVo.getRuleId());
        if (rule == null || rule.getStatus() == 0)
            throw new GlobalException(ResultCode.DELETE_RULE_NOT_EXIST);

        // 2. 修改规则状态和修改者的用户ID和修改时间
        rule.setStatus(0);
        rule.setEditorId(ruleVo.getUserId());
        rule.setUpdateTime(new Date());
        int deleteRuleCount = ruleMapper.updateById(rule);
        if (deleteRuleCount <= 0)
            throw new GlobalException(ResultCode.DELETE_RULE_FAIL);

        // 3. 删除场景区-规则的关联(必定有记录)
        UpdateWrapper<SceneRule> sceneRuleUpdateWrapper = new UpdateWrapper<>();
        sceneRuleUpdateWrapper.eq("rule_id", ruleVo.getRuleId())
                .set("status", 0);
        int deleteSceneRuleCount = sceneRuleMapper.update(null, sceneRuleUpdateWrapper);
        if (deleteSceneRuleCount <= 0)
            throw new GlobalException(ResultCode.DELETE_SCENE_RULE_FAIL);

        // 4. 在规则-用户表里设置删除状态(必定有记录)
        UpdateWrapper<RuleUser> ruleUserUpdateWrapper = new UpdateWrapper<>();
        ruleUserUpdateWrapper.eq("rule_id", ruleVo.getRuleId())
                .set("status", 0);
        int deleteRuleUserCount = ruleUserMapper.update(null, ruleUserUpdateWrapper);
        if (deleteRuleUserCount <= 0)
            throw new GlobalException(ResultCode.DELETE_RULE_USER_FAIL);

        // 5. 在规则-词汇表里设置删除状态(可能没有词汇与节点关联)
        QueryWrapper<WordRule> wordRuleQueryWrapper = new QueryWrapper<>();
        wordRuleQueryWrapper.eq("rule_id", ruleVo.getRuleId());
        wordRuleQueryWrapper.gt("status", 0);
        Integer needDeleteWordRuleCount = wordRuleMapper.selectCount(wordRuleQueryWrapper);

        UpdateWrapper<WordRule> wordRuleUpdateWrapper = new UpdateWrapper<>();
        wordRuleUpdateWrapper.eq("rule_id", ruleVo.getRuleId())
                .gt("status", 0)
                .set("status", 0);
        int deleteWordRuleCount = wordRuleMapper.update(null, wordRuleUpdateWrapper);
        if (needDeleteWordRuleCount != deleteWordRuleCount)
            throw new GlobalException(ResultCode.DELETE_WORD_RULE_FAIL);

        // 6. 在规则-句型表里设置删除状态
        QueryWrapper<SentenceRule> sentenceRuleQueryWrapper = new QueryWrapper<>();
        sentenceRuleQueryWrapper.eq("rule_id", ruleVo.getRuleId());
        sentenceRuleQueryWrapper.gt("status", 0);
        Integer needDeleteSentenceRuleCount = sentenceRuleMapper.selectCount(sentenceRuleQueryWrapper);

        UpdateWrapper<SentenceRule> sentenceRuleUpdateWrapper = new UpdateWrapper<>();
        sentenceRuleUpdateWrapper.eq("rule_id", ruleVo.getRuleId())
                .gt("status", 0).set("status", 0);
        int deleteSentenceRuleCount = sentenceRuleMapper.update(null, sentenceRuleUpdateWrapper);
        if (needDeleteSentenceRuleCount != deleteSentenceRuleCount)
            throw new GlobalException(ResultCode.DELETE_SENTENCE_RULE_FAIL);
        return true;
    }
}
