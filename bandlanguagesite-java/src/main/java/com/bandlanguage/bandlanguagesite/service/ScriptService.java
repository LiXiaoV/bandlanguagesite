package com.bandlanguage.bandlanguagesite.service;


import com.bandlanguage.bandlanguagesite.model.vo.ScriptVo;

import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-22 14:48
 */
public interface ScriptService {
    /**
     * 保存剧本
     *
     * @param scriptVo 剧本的输入实体类
     * @return 保存是否成功
     */
    Boolean SaveScript(ScriptVo scriptVo);

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
     * 根据ID获取剧本的详情
     *
     * @param scriptId 剧本ID
     * @return 剧本的视图类
     */
    ScriptVo getMyScriptDetailById(Long scriptId);

    /**
     * 修改剧本
     *
     * @param scriptVo 剧本的视图类
     * @return 修改剧本是否成功
     */
    Boolean editScript(ScriptVo scriptVo);

    /**
     * 根据ID删除剧本
     *
     * @param scriptId 剧本ID
     * @return 删除是否成功
     */
    Boolean deleteScriptById(Long scriptId);
}
