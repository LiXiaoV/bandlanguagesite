package com.bandlanguage.bandlanguagesite.service;


import com.bandlanguage.bandlanguagesite.model.vo.WordVo;

import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-22 14:48
 */
public interface WordService {
    /**
     * 保存词汇
     *
     * @param wordVo 词的实体类
     * @return 影响的行数
     */
    Boolean SaveWord(WordVo wordVo);

    /**
     * 通过场景区Id获取所有词汇
     *
     * @param SceneId 场景区ID
     * @return 词汇对象数组
     */
    List<WordVo> getAllWordsBySceneId(Long SceneId);

    /**
     * 通过场景区ID和用户ID获取所有词汇
     *
     * @param sceneId 场景区ID
     * @param userId  用户ID
     * @return 词汇视图类数组
     */
    List<WordVo> getWordsBySceneIdAndUserId(Long sceneId, Long userId);

    /**
     * 通过词汇ID获取词的详细信息
     *
     * @param wordId 词汇ID
     * @return 词汇的视图实体类
     */
    WordVo getWordDetailById(Long wordId);

    /**
     * 通过关键字查询相关词汇
     **/
    List<WordVo> getWordsByKeyword(String keyword);

    /**
     * 通过关键字分页查询相关词汇
     **/
    List<WordVo> getWordsByKeywordInPage(String keyword, Long pageNum, Long pageSize);

    Long getWordsTotalByKeyword(String keyword);

    /**
     * 修改词汇
     *
     * @param wordVo 词的视图类
     * @return 修改是否成功
     */
    Boolean editWord(WordVo wordVo);

    /**
     * 删除词汇
     *
     * @param wordVo 词汇的视图类，主要用来传词汇ID和删除者的用户ID
     * @return 删除词汇是否成功
     */
    Boolean deleteWord(WordVo wordVo);

    /**
     * 获取所有的词汇
     *
     * @return 词的视图类数组
     */
    List<WordVo> getAllWords();

    /**
     * 根据ID跟新词汇录入状态
     *
     * @param wordId 词汇ID
     * @return 更新是否成功
     */
    Boolean updateTypeInStatusByWordId(Long wordId);
}
