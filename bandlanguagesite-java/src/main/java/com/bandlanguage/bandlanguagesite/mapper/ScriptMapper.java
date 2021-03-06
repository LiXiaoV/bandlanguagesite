package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.Script;
import com.bandlanguage.bandlanguagesite.model.vo.ScriptVo;
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

    List<ScriptVo> getAllScriptsBySceneId(Long sceneId);

    /**
     * 根据场景区ID和用户ID获得剧本
     *
     * @param sceneId 场景区ID
     * @param userId  用户ID
     * @return 剧本的视图类数组
     */
    List<ScriptVo> getMyScriptsBySceneIdAndUserId(Long sceneId, Long userId);

    /**
     * 获取火热的剧本
     *
     * @param limitCount 获取的数量
     * @return 剧本视图类数组
     */
    List<ScriptVo> getHotScripts(Long limitCount);

    /**
     * 获得所有剧本
     *
     * @return 剧本的视图类数组
     */
    List<ScriptVo> getAllScripts();

//    List<Script> getAllScriptsBySceneId(Long sceneId);

    List<Script> getAllScriptsInPage(@Param("offset") Long offset, @Param("size") Long size);

    Long getScriptsTotal();
}
