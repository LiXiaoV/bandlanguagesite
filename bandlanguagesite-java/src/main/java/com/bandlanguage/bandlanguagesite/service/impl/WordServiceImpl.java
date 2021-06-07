package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.SceneWordMapper;
import com.bandlanguage.bandlanguagesite.mapper.UserMapper;
import com.bandlanguage.bandlanguagesite.mapper.WordMapper;
import com.bandlanguage.bandlanguagesite.mapper.WordUserMapper;
import com.bandlanguage.bandlanguagesite.model.entity.SceneWord;
import com.bandlanguage.bandlanguagesite.model.entity.User;
import com.bandlanguage.bandlanguagesite.model.entity.Word;
import com.bandlanguage.bandlanguagesite.model.entity.WordUser;
import com.bandlanguage.bandlanguagesite.model.vo.WordVo;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.WordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-22 14:53
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordMapper wordMapper;

    @Autowired
    private SceneWordMapper sceneWordMapper;

    @Autowired
    private WordUserMapper wordUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Boolean SaveWord(WordVo wordVo) {
        Word word = Word.builder().name(wordVo.getName())
                .description(wordVo.getDescription())
                .example(wordVo.getExample())
                .type(wordVo.getType())
                .synonym(wordVo.getSynonym())
                .isTypeIn(wordVo.getIsTypeIn())
                .creatorId(wordVo.getUserId())
                .editorId(wordVo.getUserId())
                .updateTime(new Date()).build();
        int res = wordMapper.insert(word);
        if(res <= 0)
            throw new GlobalException(ResultCode.SAVE_WORD_FAIL);

        // 插入词汇与场景区的关联
        SceneWord sceneWord = SceneWord.builder().sceneId(wordVo.getSceneId())
                .wordId(word.getWordId()).build();
        int res1 = sceneWordMapper.insert(sceneWord);
        if(res1 <= 0)
            throw new GlobalException(ResultCode.SAVE_SCENE_WORD_FAIL);

        // 插入词汇用户的关联
        WordUser wordUser = WordUser.builder().wordId(word.getWordId())
                .userId(wordVo.getUserId())
                .updateTime(new Date()).build();
        int res2 = wordUserMapper.insert(wordUser);
        if(res2 <= 0)
            throw new GlobalException(ResultCode.SAVE_WORD_USER_FAIL);
        return true;
    }

    @Override
    public List<WordVo> getAllWordsBySceneId(Long SceneId) {
        return wordMapper.getAllWordsBySceneId(SceneId);
    }

    @Override
    public List<WordVo> getWordsBySceneIdAndUserId(Long sceneId, Long userId) {
        return wordMapper.getWordsBySceneIdAndUserId(sceneId,userId);
    }

    @Override
    public WordVo getWordDetailById(Long wordId) {
        Word word = wordMapper.selectById(wordId);
        if(word == null)
            throw new GlobalException(ResultCode.SELECT_WORD_NOT_EXIST);

        User creator = userMapper.selectById(word.getCreatorId());
        User editor = userMapper.selectById(word.getEditorId());
        return WordVo.builder().wordId(word.getWordId())
                .name(word.getName())
                .description(word.getDescription())
                .example(word.getExample())
                .type(word.getType())
                .synonym(word.getSynonym())
                .creatorId(word.getCreatorId())
                .creatorUsername(creator.getUsername())
                .creatorNickname(creator.getNickname())
                .editorId(word.getEditorId())
                .editorUsername(editor.getUsername())
                .editorNickname(editor.getNickname())
                .updateTime(word.getUpdateTime())
                .isTypeIn(word.getIsTypeIn()).build();
    }

    @Override
    public List<WordVo> getWordsByKeyword(String keyword) {
        return wordMapper.getWordsByKeyword(keyword);
    }

    @Override
    public List<WordVo> getWordsByKeywordInPage(String keyword, Long pageNum, Long pageSize) {
        return wordMapper.getWordsByKeywordInPage(keyword,(pageNum-1)*pageSize,pageSize);
    }

    @Override
    public Long getWordsTotalByKeyword(String keyword) {
        return wordMapper.getWordsTotalByKeyword(keyword);
    }

    @Override
    @Transactional
    public Boolean editWord(WordVo wordVo) {
        Word word = Word.builder().wordId(wordVo.getWordId())
                .name(wordVo.getName())
                .description(wordVo.getDescription())
                .example(wordVo.getExample())
                .type(wordVo.getType())
                .synonym(wordVo.getSynonym())
                .editorId(wordVo.getUserId())
                .updateTime(new Date()).build();
        int cnt = wordMapper.updateById(word);
        if(cnt <= 0)
            throw new GlobalException(ResultCode.EDIT_WORD_FAIL);

        // 查询此用户是否修改或创建过这个词汇，如果是，则跟新时间，如果不是，则插入记录
        QueryWrapper<WordUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",wordVo.getUserId());
        queryWrapper.eq("word_id",wordVo.getWordId());
        WordUser wordUser = wordUserMapper.selectOne(queryWrapper);
        if(wordUser != null){
            wordUser.setUpdateTime(new Date());
            int cnt1 = wordUserMapper.updateById(wordUser);
            if(cnt1 <= 0)
                throw new GlobalException(ResultCode.UPDATE_WORD_USER_FAIL);
        }else {
            WordUser insertWordUser = WordUser.builder().wordId(wordVo.getWordId())
                    .userId(wordVo.getUserId())
                    .updateTime(new Date()).build();
            int cnt2 = wordUserMapper.insert(insertWordUser);
            if(cnt2 <= 0)
                throw new GlobalException(ResultCode.SAVE_WORD_USER_FAIL);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteWordById(Long wordId) {
        Word word = wordMapper.selectById(wordId);
        if(word == null)
            throw new GlobalException(ResultCode.DELETE_WORD_NOT_EXIST);
        word.setStatus(0);

        // 更新词汇状态，肯定有记录要修改
        int cnt1 = wordMapper.updateById(word);
        if(cnt1 <= 0)
            throw new GlobalException(ResultCode.EDIT_WORD_FAIL);

        // 更新词汇-场景区关联表，肯定有记录要修改
        UpdateWrapper<SceneWord> sceneWordUpdateWrapper = new UpdateWrapper<>();
        sceneWordUpdateWrapper.eq("word_id",word.getWordId()).set("status",0);
        int cnt2 = sceneWordMapper.update(null, sceneWordUpdateWrapper);
        if(cnt2 <= 0)
            throw new GlobalException(ResultCode.UPDATE_SCENE_WORD_FAIL);

        // 更新词汇-用户关联表，肯定有记录要修改
        UpdateWrapper<WordUser> wordUserUpdateWrapper = new UpdateWrapper<>();
        wordUserUpdateWrapper.eq("word_id",word.getWordId()).set("status",0);
        int cnt3 = wordUserMapper.update(null, wordUserUpdateWrapper);
        if(cnt3 <= 0)
            throw new GlobalException(ResultCode.UPDATE_WORD_USER_FAIL);
        return true;
    }

    @Override
    public List<WordVo> getAllWords() {
        return wordMapper.getAllWords();
    }

    @Override
    public Boolean updateTypeInStatusByWordId(Long wordId) {
        Word word = Word.builder().wordId(wordId)
                .isTypeIn(1).build();
        int res = wordMapper.updateById(word);

        if(res <= 0)
            throw new GlobalException(ResultCode.EDIT_WORD_FAIL);
        return true;
    }
}
