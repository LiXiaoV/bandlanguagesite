package com.bandlanguage.bandlanguagesite.service;


import com.bandlanguage.bandlanguagesite.model.vo.ParadigmVo;
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
     * 通过关键字查找句型
     **/
    List<SentenceVo> getSentencesByKeyword(String keyword);

    /**
     * 通过关键字分页查找句型
     **/
    List<SentenceVo> getSentencesByKeywordInPage(String keyword, Long pageNum, Long pageSize);

    List<SentenceVo> getSentencesByKeywordInPageWithOffset(String keyword, Long offset, Long size);

    Long getSentencesTotalByKeyword(String keyword);

    /**
     * 修改句型
     *
     * @param sentenceVo 句型的视图类
     * @return 修改是否成功
     */
    Boolean editSentence(SentenceVo sentenceVo);

    /**
     * 删除句型
     *
     * @param sentenceVo 句型的视图类
     * @return 删除句型是否成功
     */
    Boolean deleteSentence(SentenceVo sentenceVo);

    /**
     * 根据ID修改句型录入状态
     *
     * @param sentenceId 句型ID
     * @return 修改录入状态是否成功
     */
    Boolean updateTypeInStatusBySentenceId(Long sentenceId);

    /**
     * 添加中间范式
     *
     * @param paradigmVo 中间范式的视图类
     * @return 添加中间范式是否成功
     */
    Boolean SaveParadigm(ParadigmVo paradigmVo);

    /**
     * 根据ID查询中间范式详情
     *
     * @param paradigmId 中间范式的ID
     * @return 中间范式的视图类
     */
    ParadigmVo getParadigmDetailById(Long paradigmId);

    /**
     * 删除中间范式
     *
     * @param paradigmVo 中间范式的视图类，主要传ID和userId
     * @return 删除中间范式是否成功
     */
    Boolean deleteParadigm(ParadigmVo paradigmVo);

    /**
     * 修改中间范式
     *
     * @param paradigmVo 中间范式的视图类
     * @return 修改中间范式是否成功
     */
    Boolean updateParadigm(ParadigmVo paradigmVo);
}
