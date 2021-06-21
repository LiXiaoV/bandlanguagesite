package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.*;
import com.bandlanguage.bandlanguagesite.model.entity.*;
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

    @Autowired
    private WordRuleMapper wordRuleMapper;

    @Autowired
    private WordNodeMapper wordNodeMapper;

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
        int insertWordCount = wordMapper.insert(word);
        if (insertWordCount <= 0)
            throw new GlobalException(ResultCode.SAVE_WORD_FAIL);

        // 插入词汇与场景区的关联
        SceneWord sceneWord = SceneWord.builder().sceneId(wordVo.getSceneId())
                .wordId(word.getWordId()).build();
        int insertSceneWordCount = sceneWordMapper.insert(sceneWord);
        if (insertSceneWordCount <= 0)
            throw new GlobalException(ResultCode.SAVE_SCENE_WORD_FAIL);

        // 插入词汇用户的关联
        WordUser wordUser = WordUser.builder().wordId(word.getWordId())
                .userId(wordVo.getUserId())
                .updateTime(new Date()).build();
        int insertWordUserCount = wordUserMapper.insert(wordUser);
        if (insertWordUserCount <= 0)
            throw new GlobalException(ResultCode.SAVE_WORD_USER_FAIL);
        return true;
    }

    @Override
    public List<WordVo> getAllWordsBySceneId(Long SceneId) {
        return wordMapper.getAllWordsBySceneId(SceneId);
    }

    @Override
    public List<WordVo> getWordsBySceneIdAndUserId(Long sceneId, Long userId) {
        return wordMapper.getWordsBySceneIdAndUserId(sceneId, userId);
    }

    @Override
    public WordVo getWordDetailById(Long wordId) {
        Word word = wordMapper.selectById(wordId);
        if (word == null || word.getStatus() == 0)
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
        return wordMapper.getWordsByKeywordInPage(keyword, (pageNum - 1) * pageSize, pageSize);
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
        int updateWordCount = wordMapper.updateById(word);
        if (updateWordCount <= 0)
            throw new GlobalException(ResultCode.EDIT_WORD_FAIL);

        // 查询此用户是否修改或创建过这个词汇，如果是，则跟新时间，如果不是，则插入记录
        QueryWrapper<WordUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", wordVo.getUserId());
        queryWrapper.eq("word_id", wordVo.getWordId());
        WordUser wordUser = wordUserMapper.selectOne(queryWrapper);
        if (wordUser != null) {
            wordUser.setUpdateTime(new Date());
            int updateWordUserCount = wordUserMapper.updateById(wordUser);
            if (updateWordUserCount <= 0)
                throw new GlobalException(ResultCode.UPDATE_WORD_USER_FAIL);
        } else {
            WordUser insertWordUser = WordUser.builder().wordId(wordVo.getWordId())
                    .userId(wordVo.getUserId())
                    .updateTime(new Date()).build();
            int insertWordUserCount = wordUserMapper.insert(insertWordUser);
            if (insertWordUserCount <= 0)
                throw new GlobalException(ResultCode.SAVE_WORD_USER_FAIL);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteWord(WordVo wordVo) {
        Word word = wordMapper.selectById(wordVo.getWordId());
        if (word == null || word.getStatus() == 0)
            throw new GlobalException(ResultCode.DELETE_WORD_NOT_EXIST);
        word.setStatus(0);
        word.setEditorId(wordVo.getUserId());
        word.setUpdateTime(new Date());

        // 更新词汇状态，肯定有记录要修改
        int deleteWordCount = wordMapper.updateById(word);
        if (deleteWordCount <= 0)
            throw new GlobalException(ResultCode.EDIT_WORD_FAIL);

        // 更新词汇-场景区关联表，词汇一定属于某个场景区
        UpdateWrapper<SceneWord> sceneWordUpdateWrapper = new UpdateWrapper<>();
        sceneWordUpdateWrapper.eq("word_id", word.getWordId()).set("status", 0);
        int deleteSceneWordCount = sceneWordMapper.update(null, sceneWordUpdateWrapper);
        if (deleteSceneWordCount <= 0)
            throw new GlobalException(ResultCode.UPDATE_SCENE_WORD_FAIL);

        // 更新词汇-用户关联表，至少在插入词汇的时候会插入一条操作者的记录
        UpdateWrapper<WordUser> wordUserUpdateWrapper = new UpdateWrapper<>();
        wordUserUpdateWrapper.eq("word_id", word.getWordId()).set("status", 0);
        int deleteWordUserCount = wordUserMapper.update(null, wordUserUpdateWrapper);
        if (deleteWordUserCount <= 0)
            throw new GlobalException(ResultCode.UPDATE_WORD_USER_FAIL);

        // 5. 在规则-词汇表里设置删除状态(可能没有词汇与节点关联)
        QueryWrapper<WordRule> wordRuleQueryWrapper = new QueryWrapper<>();
        wordRuleQueryWrapper.eq("word_id", wordVo.getWordId());
        wordRuleQueryWrapper.gt("status", 0);
        Integer needDeleteWordRuleCount = wordRuleMapper.selectCount(wordRuleQueryWrapper);

        UpdateWrapper<WordRule> wordRuleUpdateWrapper = new UpdateWrapper<>();
        wordRuleUpdateWrapper.eq("word_id", wordVo.getWordId())
                .gt("status", 0)
                .set("status", 0);
        int deleteWordRuleCount = wordRuleMapper.update(null, wordRuleUpdateWrapper);
        if (needDeleteWordRuleCount != deleteWordRuleCount)
            throw new GlobalException(ResultCode.DELETE_WORD_RULE_FAIL);

        // 在节点-词汇表里设置删除状态(可能没有词汇与节点关联)
        QueryWrapper<WordNode> wordNodeQueryWrapper = new QueryWrapper<>();
        wordNodeQueryWrapper.eq("word_id", wordVo.getWordId());
        wordNodeQueryWrapper.gt("status", 0);
        Integer needDeleteWordNodeCount = wordNodeMapper.selectCount(wordNodeQueryWrapper);

        UpdateWrapper<WordNode> wordNodeUpdateWrapper = new UpdateWrapper<>();
        wordNodeUpdateWrapper.eq("word_id", wordVo.getWordId())
                .gt("status", 0)
                .set("status", 0);
        int deleteWordNodeCount = wordNodeMapper.update(null, wordNodeUpdateWrapper);
        if (needDeleteWordNodeCount != deleteWordNodeCount)
            throw new GlobalException(ResultCode.DELETE_WORD_NODE_FAIL);

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
        int updateWordCount = wordMapper.updateById(word);

        if (updateWordCount <= 0)
            throw new GlobalException(ResultCode.EDIT_WORD_FAIL);
        return true;
    }
}
