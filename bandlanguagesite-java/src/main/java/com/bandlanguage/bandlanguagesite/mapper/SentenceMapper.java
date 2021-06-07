package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.Sentence;
import com.bandlanguage.bandlanguagesite.model.vo.SentenceVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 句型的模型类
 *
 * @author xiaov
 * @since 2021-05-22 14:45
 */
@Mapper
public interface SentenceMapper extends BaseMapper<Sentence> {

    /**
     * 通过场景区Id获取所有句型
     * @param sceneId 场景区ID
     * @return 句型对象数组
     */
    List<SentenceVo> getAllSentencesBySceneId(Long sceneId);

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
     *通过关键字查找句型
     **/
    List<SentenceVo> getSentencesByKeyword(String keyword);

    List<SentenceVo> getSentencesByKeywordInPage(@Param("keyword") String keyword, @Param("offset") Long offset, @Param("size") Long size);

    /**
     * @param keyword
     * @return
     */
    Long getSentencesTotalByKeyword(String keyword);
}
