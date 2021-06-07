package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.Script;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 剧本的模型类
 *
 * @author xiaov
 * @since 2021-05-22 14:45
 */
@Mapper
public interface ScriptMapper extends BaseMapper<Script> {

    /**
     * 通过场景区Id获取所有剧本
     *
     * @param sceneId 场景区ID
     * @return 剧本对象数组
     */
    List<Script> getAllScriptsBySceneId(Long sceneId);

    List<Script> getAllScriptsInPage(@Param("offset") Long offset, @Param("size") Long size);

    Long getScriptsTotal();
}
