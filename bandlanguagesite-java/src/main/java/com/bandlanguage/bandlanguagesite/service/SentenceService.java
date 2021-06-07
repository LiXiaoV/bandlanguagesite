package com.bandlanguage.bandlanguagesite.service;


import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;

import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-22 14:48
 */
public interface SentenceService {
    /**
     * 保存句型
     *
     * @param sentenceVo 句型的实体类
     * @return 影响的行数
     */
    Boolean SaveSentence(SentenceVo sentenceVo);

    /**
     * 通过场景区Id获取所有句型
     *
     * @param SceneId 场景区ID
     * @return 句型对象数组
     */
    List<SentenceVo> getAllSentencesBySceneId(Long SceneId);

    /**
     * 获取所有的句型
     *
     * @return 句型的视图类数组
     */
    List<SentenceVo> getAllSentences();

    /**
     * 通过场景区ID和用户ID获取所有句型
     *
     * @param sceneId 场景区ID
     * @param userId  用户ID
     * @return 句型的视图类数组
     */
    List<SentenceVo> getMySentencesBySceneIdAndUserId(Long sceneId, Long userId);

    /**
     * 根据ID获取句型的详情
     *
     * @param sentenceId 句型ID
     * @return 句型的视图类
     */
    SentenceVo getMySentenceDetailById(Long sentenceId);

    /**
     *通过关键字查找句型
     **/
    List<SentenceVo> getSentencesByKeyword(String keyword);

    /**
     *通过关键字分页查找句型
     **/
    List<SentenceVo> getSentencesByKeywordInPage(String keyword,Long pageNum,Long pageSize);

    List<SentenceVo> getSentencesByKeywordInPageWithOffset(String keyword,Long offset,Long size);

    Long getSentencesTotalByKeyword(String keyword);

    /**
     * 修改句型
     *
     * @param sentenceVo 句型的视图类
     * @return 修改是否成功
     */
    Boolean editSentence(SentenceVo sentenceVo);

    /**
     * 根据ID删除句型
     *
     * @param sentenceId 句型ID
     * @return 删除是否成功
     */
    Boolean deleteSentenceById(Long sentenceId);

    /**
     * 根据ID修改句型录入状态
     *
     * @param sentenceId 句型ID
     * @return 修改录入状态是否成功
     */
    Boolean updateTypeInStatusBySentenceId(Long sentenceId);
}
