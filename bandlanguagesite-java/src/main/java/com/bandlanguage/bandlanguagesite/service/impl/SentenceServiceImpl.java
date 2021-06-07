package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.SceneSentenceMapper;
import com.bandlanguage.bandlanguagesite.mapper.SentenceMapper;
import com.bandlanguage.bandlanguagesite.mapper.SentenceUserMapper;
import com.bandlanguage.bandlanguagesite.mapper.UserMapper;
import com.bandlanguage.bandlanguagesite.model.entity.SceneSentence;
import com.bandlanguage.bandlanguagesite.model.entity.Sentence;
import com.bandlanguage.bandlanguagesite.model.entity.SentenceUser;
import com.bandlanguage.bandlanguagesite.model.entity.User;
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

    @Override
    @Transactional
    public Boolean SaveSentence(SentenceVo sentenceVo) {
        Sentence sentence = Sentence.builder().name(sentenceVo.getName())
                .description(sentenceVo.getDescription())
                .paradigm(sentenceVo.getParadigm())
                .isTypeIn(sentenceVo.getIsTypeIn())
                .creatorId(sentenceVo.getUserId())
                .editorId(sentenceVo.getUserId())
                .updateTime(new Date()).build();
        int res = sentenceMapper.insert(sentence);
        if(res <= 0)
            throw new GlobalException(ResultCode.SAVE_SENTENCE_FAIL);

        SceneSentence sceneSentence = SceneSentence.builder().sceneId(sentenceVo.getSceneId())
                .sentenceId(sentence.getSentenceId()).build();
        int res1 = sceneSentenceMapper.insert(sceneSentence);
        if(res1 <= 0)
            throw new GlobalException(ResultCode.SAVE_SCENE_SENTENCE_FAIL);

        SentenceUser sentenceUser = SentenceUser.builder().sentenceId(sentence.getSentenceId())
                .userId(sentenceVo.getUserId())
                .updateTime(new Date()).build();
        int res2 = sentenceUserMapper.insert(sentenceUser);
        if(res2 <= 0)
            throw new GlobalException(ResultCode.SAVE_SENTENCE_USER_FAIL);

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
        return sentenceMapper.getMySentencesBySceneIdAndUserId(sceneId,userId);
    }

    @Override
    public SentenceVo getMySentenceDetailById(Long sentenceId) {
        Sentence sentence = sentenceMapper.selectById(sentenceId);
        if(sentence == null)
            throw new GlobalException(ResultCode.SELECT_SENTENCE_NOT_EXIST);

        User creator = userMapper.selectById(sentence.getCreatorId());
        User editor = userMapper.selectById(sentence.getEditorId());
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
                .isTypeIn(sentence.getIsTypeIn()).build();
    }

    @Override
    public List<SentenceVo> getSentencesByKeyword(String keyword) {

        return sentenceMapper.getSentencesByKeyword(keyword);
    }

    @Override
    public List<SentenceVo> getSentencesByKeywordInPage(String keyword, Long pageNum, Long pageSize) {

        return sentenceMapper.getSentencesByKeywordInPage(keyword,(pageNum-1)*pageSize,pageSize);
    }

    @Override
    public List<SentenceVo> getSentencesByKeywordInPageWithOffset(String keyword, Long offset, Long size) {
        return sentenceMapper.getSentencesByKeywordInPage(keyword,offset,size);
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

        if(cnt <= 0)
            throw new GlobalException(ResultCode.EDIT_SENTENCE_FAIL);

        // 查询此用户是否修改或创建过这个句型，如果是，则更新时间，如果不是，则插入记录
        QueryWrapper<SentenceUser> sentenceUserQueryWrapper = new QueryWrapper<>();
        sentenceUserQueryWrapper.eq("user_id",sentenceVo.getUserId());
        sentenceUserQueryWrapper.eq("sentence_id",sentenceVo.getSentenceId());
        SentenceUser sentenceUser = sentenceUserMapper.selectOne(sentenceUserQueryWrapper);

        if(sentenceUser != null){
            sentenceUser.setUpdateTime(new Date());
            int editCount = sentenceUserMapper.updateById(sentenceUser);
            if(editCount <= 0)
                throw new GlobalException(ResultCode.UPDATE_SENTENCE_USER_FAIL);
        }else {
            SentenceUser insertSentenceUser = SentenceUser.builder().sentenceId(sentenceVo.getSentenceId())
                    .userId(sentenceVo.getUserId())
                    .updateTime(new Date()).build();
            int insertCount = sentenceUserMapper.insert(insertSentenceUser);
            if(insertCount <= 0)
                throw new GlobalException(ResultCode.SAVE_SENTENCE_USER_FAIL);
        }
        return true;
    }

    @Override
    public Boolean deleteSentenceById(Long sentenceId) {
        Sentence sentence = sentenceMapper.selectById(sentenceId);
        if(sentence == null)
            throw new GlobalException(ResultCode.DELETE_SENTENCE_NOT_EXIST);

        sentence.setStatus(0);

        // 更新句型状态，肯定有记录要修改
        int cnt1 = sentenceMapper.updateById(sentence);
        if(cnt1 <= 0)
            throw new GlobalException(ResultCode.EDIT_SENTENCE_FAIL);

        // 更新句型-场景区关联表，肯定有记录要修改
        UpdateWrapper<SceneSentence> sceneSentenceUpdateWrapper = new UpdateWrapper<>();
        sceneSentenceUpdateWrapper.eq("sentence_id",sentence.getSentenceId()).set("status",0);
        int cnt2 = sceneSentenceMapper.update(null, sceneSentenceUpdateWrapper);
        if(cnt2 <= 0)
            throw new GlobalException(ResultCode.UPDATE_SCENE_SENTENCE_FAIL);

        // 更新句型-用户关联表，肯定有记录要修改
        UpdateWrapper<SentenceUser> sentenceUserUpdateWrapper = new UpdateWrapper<>();
        sentenceUserUpdateWrapper.eq("sentence_id",sentence.getSentenceId()).set("status",0);
        int cnt3 = sentenceUserMapper.update(null, sentenceUserUpdateWrapper);
        if(cnt3 <= 0)
            throw new GlobalException(ResultCode.UPDATE_SENTENCE_USER_FAIL);

        return true;
    }

    @Override
    public Boolean updateTypeInStatusBySentenceId(Long sentenceId) {
        Sentence sentence = Sentence.builder().sentenceId(sentenceId).isTypeIn(1).build();
        int res = sentenceMapper.updateById(sentence);
        if(res <= 0)
            throw new GlobalException(ResultCode.EDIT_SENTENCE_FAIL);
        return true;
    }
}
