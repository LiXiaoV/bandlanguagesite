package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.*;
import com.bandlanguage.bandlanguagesite.model.entity.*;
import com.bandlanguage.bandlanguagesite.model.vo.ParadigmVo;
import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.SentenceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-24 02:01
 */
@Service
public class SentenceServiceImpl implements SentenceService {

    @Autowired
    private SceneSentenceMapper sceneSentenceMapper;

    @Autowired
    private SentenceMapper sentenceMapper;

    @Autowired
    private SentenceUserMapper sentenceUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ParadigmMapper paradigmMapper;

    @Autowired
    private SentenceRuleMapper sentenceRuleMapper;

    @Autowired
    private SentenceNodeMapper sentenceNodeMapper;

    @Override
    @Transactional
    public Boolean SaveSentence(SentenceVo sentenceVo) {
        // 插入句型
        Sentence sentence = Sentence.builder().name(sentenceVo.getName())
                .description(sentenceVo.getDescription())
                .paradigm(sentenceVo.getParadigm())
                .isTypeIn(sentenceVo.getIsTypeIn())
                .creatorId(sentenceVo.getUserId())
                .editorId(sentenceVo.getUserId())
                .updateTime(new Date()).build();
        int res = sentenceMapper.insert(sentence);
        if (res <= 0)
            throw new GlobalException(ResultCode.SAVE_SENTENCE_FAIL);

        // 建立句型-场景区的关联，以说明在哪个场景区插入了句型
        SceneSentence sceneSentence = SceneSentence.builder().sceneId(sentenceVo.getSceneId())
                .sentenceId(sentence.getSentenceId()).build();
        int res1 = sceneSentenceMapper.insert(sceneSentence);
        if (res1 <= 0)
            throw new GlobalException(ResultCode.SAVE_SCENE_SENTENCE_FAIL);

        // 建立句型-用户的关联，以说明是谁修改或插入了句型
        SentenceUser sentenceUser = SentenceUser.builder().sentenceId(sentence.getSentenceId())
                .userId(sentenceVo.getUserId())
                .updateTime(new Date()).build();
        int res2 = sentenceUserMapper.insert(sentenceUser);
        if (res2 <= 0)
            throw new GlobalException(ResultCode.SAVE_SENTENCE_USER_FAIL);

        // 保存中间范式
        List<Paradigm> paradigms = sentenceVo.getParadigms();
        for (Paradigm paradigm : paradigms) {
            paradigm.setSentenceId(sentence.getSentenceId());
            paradigm.setCreatorId(sentenceVo.getUserId());
            paradigm.setEditorId(sentenceVo.getUserId());
            paradigm.setUpdateTime(new Date());
            int insertParadigmCount = paradigmMapper.insert(paradigm);
            if (insertParadigmCount <= 0)
                throw new GlobalException(ResultCode.SAVE_PARADIGM_FAIL);
        }
        return true;
    }

    @Override
    public List<SentenceVo> getAllSentencesBySceneId(Long SceneId) {
        return sentenceMapper.getAllSentencesBySceneId(SceneId);
    }

    @Override
    public List<SentenceVo> getAllSentences() {
        return sentenceMapper.getAllSentences();
    }

    @Override
    public List<SentenceVo> getMySentencesBySceneIdAndUserId(Long sceneId, Long userId) {
        return sentenceMapper.getMySentencesBySceneIdAndUserId(sceneId, userId);
    }

    @Override
    public SentenceVo getMySentenceDetailById(Long sentenceId) {
        Sentence sentence = sentenceMapper.selectById(sentenceId);
        if (sentence == null)
            throw new GlobalException(ResultCode.SELECT_SENTENCE_NOT_EXIST);

        User creator = userMapper.selectById(sentence.getCreatorId());
        User editor = userMapper.selectById(sentence.getEditorId());
        QueryWrapper<Paradigm> paradigmQueryWrapper = new QueryWrapper<>();
        paradigmQueryWrapper.eq("sentence_id", sentenceId);
        paradigmQueryWrapper.gt("status", 0);
        List<Paradigm> paradigms = paradigmMapper.selectList(paradigmQueryWrapper);
        return SentenceVo.builder().sentenceId(sentence.getSentenceId())
                .name(sentence.getName())
                .description(sentence.getDescription())
                .paradigm(sentence.getParadigm())
                .creatorId(sentence.getCreatorId())
                .creatorUsername(creator.getUsername())
                .creatorNickname(creator.getNickname())
                .editorId(sentence.getEditorId())
                .editorUsername(editor.getUsername())
                .editorNickname(editor.getNickname())
                .updateTime(sentence.getUpdateTime())
                .isTypeIn(sentence.getIsTypeIn())
                .paradigms(paradigms).build();
    }

    @Override
    public List<SentenceVo> getSentencesByKeyword(String keyword) {

        return sentenceMapper.getSentencesByKeyword(keyword);
    }

    @Override
    public List<SentenceVo> getSentencesByKeywordInPage(String keyword, Long pageNum, Long pageSize) {

        return sentenceMapper.getSentencesByKeywordInPage(keyword, (pageNum - 1) * pageSize, pageSize);
    }

    @Override
    public List<SentenceVo> getSentencesByKeywordInPageWithOffset(String keyword, Long offset, Long size) {
        return sentenceMapper.getSentencesByKeywordInPage(keyword, offset, size);
    }

    @Override
    public Long getSentencesTotalByKeyword(String keyword) {
        return sentenceMapper.getSentencesTotalByKeyword(keyword);
    }

    @Override
    @Transactional
    public Boolean editSentence(SentenceVo sentenceVo) {
        Sentence sentence = Sentence.builder().sentenceId(sentenceVo.getSentenceId())
                .name(sentenceVo.getName())
                .description(sentenceVo.getDescription())
                .paradigm(sentenceVo.getParadigm())
                .editorId(sentenceVo.getUserId())
                .updateTime(new Date()).build();
        int cnt = sentenceMapper.updateById(sentence);

        if (cnt <= 0)
            throw new GlobalException(ResultCode.EDIT_SENTENCE_FAIL);

        // 查询此用户是否修改或创建过这个句型，如果是，则更新时间，如果不是，则插入记录
        QueryWrapper<SentenceUser> sentenceUserQueryWrapper = new QueryWrapper<>();
        sentenceUserQueryWrapper.eq("user_id", sentenceVo.getUserId());
        sentenceUserQueryWrapper.eq("sentence_id", sentenceVo.getSentenceId());
        SentenceUser sentenceUser = sentenceUserMapper.selectOne(sentenceUserQueryWrapper);

        if (sentenceUser != null) {
            sentenceUser.setUpdateTime(new Date());
            int editCount = sentenceUserMapper.updateById(sentenceUser);
            if (editCount <= 0)
                throw new GlobalException(ResultCode.UPDATE_SENTENCE_USER_FAIL);
        } else {
            SentenceUser insertSentenceUser = SentenceUser.builder().sentenceId(sentenceVo.getSentenceId())
                    .userId(sentenceVo.getUserId())
                    .updateTime(new Date()).build();
            int insertCount = sentenceUserMapper.insert(insertSentenceUser);
            if (insertCount <= 0)
                throw new GlobalException(ResultCode.SAVE_SENTENCE_USER_FAIL);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteSentence(SentenceVo sentenceVo) {
        Sentence sentence = sentenceMapper.selectById(sentenceVo.getSentenceId());
        if (sentence == null || sentence.getStatus() == 0)
            throw new GlobalException(ResultCode.DELETE_SENTENCE_NOT_EXIST);

        sentence.setStatus(0);
        sentence.setEditorId(sentenceVo.getUserId());
        sentence.setUpdateTime(new Date());

        // 更新句型状态，肯定有记录要修改
        int deleteSentenceCount = sentenceMapper.updateById(sentence);
        if (deleteSentenceCount <= 0)
            throw new GlobalException(ResultCode.EDIT_SENTENCE_FAIL);

        // 更新属于某一句型的中间范式(可能没有)
        // 先查总数
        QueryWrapper<Paradigm> paradigmQueryWrapper = new QueryWrapper<>();
        paradigmQueryWrapper.eq("sentence_id", sentenceVo.getSentenceId());
        paradigmQueryWrapper.gt("status", 0);
        Integer needDeleteParadigmCount = paradigmMapper.selectCount(paradigmQueryWrapper);

        UpdateWrapper<Paradigm> paradigmUpdateWrapper = new UpdateWrapper<>();
        paradigmUpdateWrapper.eq("sentence_id", sentence.getSentenceId())
                .gt("status", 0).set("status", 0);
        int deleteParadigmCount = paradigmMapper.update(null, paradigmUpdateWrapper);
        if (needDeleteParadigmCount != deleteParadigmCount)
            throw new GlobalException(ResultCode.DELETE_PARADIGM_FAIL);

        // 更新句型-场景区关联表，句型一定属于某场景区，所以肯定有记录
        UpdateWrapper<SceneSentence> sceneSentenceUpdateWrapper = new UpdateWrapper<>();
        sceneSentenceUpdateWrapper.eq("sentence_id", sentence.getSentenceId()).set("status", 0);
        int deleteSceneSentenceCount = sceneSentenceMapper.update(null, sceneSentenceUpdateWrapper);
        if (deleteSceneSentenceCount <= 0)
            throw new GlobalException(ResultCode.UPDATE_SCENE_SENTENCE_FAIL);

        // 更新句型-用户关联表，插入句型的时候（即使没有修改过）一定会留下谁插入的记录，所以这里一定有记录
        UpdateWrapper<SentenceUser> sentenceUserUpdateWrapper = new UpdateWrapper<>();
        sentenceUserUpdateWrapper.eq("sentence_id", sentence.getSentenceId()).set("status", 0);
        int deleteSentenceUserCount = sentenceUserMapper.update(null, sentenceUserUpdateWrapper);
        if (deleteSentenceUserCount <= 0)
            throw new GlobalException(ResultCode.UPDATE_SENTENCE_USER_FAIL);

        // 在规则-句型表里设置删除状态（可能没有记录）
        QueryWrapper<SentenceRule> sentenceRuleQueryWrapper = new QueryWrapper<>();
        sentenceRuleQueryWrapper.eq("sentence_id", sentenceVo.getSentenceId());
        sentenceRuleQueryWrapper.gt("status", 0);
        Integer needDeleteSentenceRuleCount = sentenceRuleMapper.selectCount(sentenceRuleQueryWrapper);

        UpdateWrapper<SentenceRule> sentenceRuleUpdateWrapper = new UpdateWrapper<>();
        sentenceRuleUpdateWrapper.eq("sentence_id", sentenceVo.getSentenceId())
                .gt("status", 0).set("status", 0);
        int deleteSentenceRuleCount = sentenceRuleMapper.update(null, sentenceRuleUpdateWrapper);
        if (needDeleteSentenceRuleCount != deleteSentenceRuleCount)
            throw new GlobalException(ResultCode.DELETE_SENTENCE_RULE_FAIL);

        // 6. 在节点-句型表里设置删除状态,可能没有记录
        QueryWrapper<SentenceNode> sentenceNodeQueryWrapper = new QueryWrapper<>();
        sentenceNodeQueryWrapper.eq("sentence_id", sentenceVo.getSentenceId());
        sentenceNodeQueryWrapper.gt("status", 0);
        Integer needDeleteSentenceNodeCount = sentenceNodeMapper.selectCount(sentenceNodeQueryWrapper);

        UpdateWrapper<SentenceNode> sentenceNodeUpdateWrapper = new UpdateWrapper<>();
        sentenceNodeUpdateWrapper.eq("sentence_id", sentenceVo.getSentenceId())
                .gt("status", 0).set("status", 0);
        int deleteSentenceNodeCount = sentenceNodeMapper.update(null, sentenceNodeUpdateWrapper);
        if (needDeleteSentenceNodeCount != deleteSentenceNodeCount)
            throw new GlobalException(ResultCode.DELETE_SENTENCE_NODE_FAIL);

        return true;
    }

    @Override
    @Transactional
    public Boolean updateTypeInStatusBySentenceId(Long sentenceId) {
        Sentence sentence = Sentence.builder().sentenceId(sentenceId).isTypeIn(1).build();
        int res = sentenceMapper.updateById(sentence);
        if (res <= 0)
            throw new GlobalException(ResultCode.EDIT_SENTENCE_FAIL);
        return true;
    }

    private Boolean updateSentenceEditorAndTime(Long sentenceId, Long userId) {
        Sentence sentence = Sentence.builder().sentenceId(sentenceId)
                .editorId(userId).updateTime(new Date()).build();
        int updateSentenceCount = sentenceMapper.updateById(sentence);
        if (updateSentenceCount <= 0)
            throw new GlobalException(ResultCode.EDIT_SENTENCE_FAIL);

        return true;
    }

    @Override
    @Transactional
    public Boolean SaveParadigm(ParadigmVo paradigmVo) {
        // 插入中间范式
        Paradigm paradigm = Paradigm.builder().sentenceId(paradigmVo.getSentenceId())
                .easyParadigm(paradigmVo.getEasyParadigm())
                .example(paradigmVo.getExample())
                .creatorId(paradigmVo.getUserId())
                .editorId(paradigmVo.getUserId())
                .updateTime(new Date()).build();
        int insertParadigmCnt = paradigmMapper.insert(paradigm);
        if (insertParadigmCnt <= 0)
            throw new GlobalException(ResultCode.SAVE_PARADIGM_FAIL);

        // 修改句型的修改者和更新时间
        updateSentenceEditorAndTime(paradigmVo.getSentenceId(), paradigmVo.getUserId());

        return true;
    }

    @Override
    public ParadigmVo getParadigmDetailById(Long paradigmId) {
        Paradigm paradigm = paradigmMapper.selectById(paradigmId);
        if (paradigm == null || paradigm.getStatus() == 0)
            throw new GlobalException(ResultCode.SELECT_PARADIGM_NOT_EXIST);

        return ParadigmVo.builder().paradigmId(paradigm.getParadigmId())
                .sentenceId(paradigm.getSentenceId())
                .easyParadigm(paradigm.getEasyParadigm())
                .example(paradigm.getExample())
                .creatorId(paradigm.getCreatorId())
                .editorId(paradigm.getEditorId())
                .updateTime(paradigm.getUpdateTime())
                .status(paradigm.getStatus()).build();
    }

    @Override
    @Transactional
    public Boolean deleteParadigm(ParadigmVo paradigmVo) {

        Paradigm paradigm = paradigmMapper.selectById(paradigmVo.getParadigmId());
        if (paradigm == null || paradigm.getStatus() == 0)
            throw new GlobalException(ResultCode.DELETE_PARADIGM_NOT_EXIST);

        // 设置谁删除的，并设置删除时间
        paradigm.setEditorId(paradigmVo.getUserId());
        paradigm.setUpdateTime(new Date());
        // 逻辑删除
        paradigm.setStatus(0);
        int deleteParadigmCount = paradigmMapper.updateById(paradigm);
        if (deleteParadigmCount <= 0)
            throw new GlobalException(ResultCode.DELETE_PARADIGM_FAIL);

        // 修改句型的修改者和更新时间
        updateSentenceEditorAndTime(paradigm.getSentenceId(), paradigmVo.getUserId());
        return true;
    }

    @Override
    @Transactional
    public Boolean updateParadigm(ParadigmVo paradigmVo) {
        Paradigm selectParadigm = paradigmMapper.selectById(paradigmVo.getParadigmId());
        if (selectParadigm == null || selectParadigm.getStatus() == 0)
            throw new GlobalException(ResultCode.UPDATE_PARADIGM_NOT_EXIST);

        // 插入中间范式
        Paradigm paradigm = Paradigm.builder().paradigmId(paradigmVo.getParadigmId())
                .easyParadigm(paradigmVo.getEasyParadigm())
                .example(paradigmVo.getExample())
                .editorId(paradigmVo.getUserId())
                .updateTime(new Date()).build();
        int updateParadigmCount = paradigmMapper.updateById(paradigm);
        if (updateParadigmCount <= 0)
            throw new GlobalException(ResultCode.UPDATE_PARADIGM_FAIL);

        // 修改句型的修改者和更新时间
        updateSentenceEditorAndTime(selectParadigm.getSentenceId(), paradigmVo.getUserId());
        return true;
    }
}
