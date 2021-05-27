package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.Sentence;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
    List<Sentence> getAllSentencesBySceneId(Long sceneId);
}
