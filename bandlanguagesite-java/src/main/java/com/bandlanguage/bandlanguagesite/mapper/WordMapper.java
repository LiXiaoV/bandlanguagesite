package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.Word;
import com.bandlanguage.bandlanguagesite.model.vo.WordVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 词汇的模型类
 *
 * @author xiaov
 * @since 2021-05-22 14:45
 */
@Mapper
public interface WordMapper extends BaseMapper<Word> {

    /**
     * 通过场景区Id获取所有词汇
     *
     * @param sceneId 场景区ID
     * @return 词汇对象数组
     */
    List<WordVo> getAllWordsBySceneId(Long sceneId);

    /**
     * 通过场景区ID和用户ID获取所有词汇
     *
     * @param sceneId 场景区ID
     * @param userId  用户ID
     * @return 词汇视图类数组
     */
    List<WordVo> getWordsBySceneIdAndUserId(Long sceneId, Long userId);

    /**
     * 获取所有的词汇
     *
     * @return 词的视图类数组
     */
    List<WordVo> getAllWords();

    /**
     *通过关键字获取词汇
     **/
    List<WordVo> getWordsByKeyword(String keyword);
}
