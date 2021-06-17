package com.bandlanguage.bandlanguagesite.service;


import com.bandlanguage.bandlanguagesite.model.entity.Script;
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
     * 删除剧本
     *
     * @param scriptVo 剧本的视图类，用来传剧本ID和操作者的用户ID
     * @return 删除剧本是否成功
     */
    Boolean deleteScript(ScriptVo scriptVo);

    /**
     * 获取火热的剧本
     *
     * @param limitCount 获取的数量
     * @return 剧本视图类数组
     */
    List<ScriptVo> getHotScripts(Long limitCount);

    /**
     * 给剧本运行次数+1
     *
     * @param ScriptId 剧本ID
     * @return 增加运行次数是否成功
     */
    Boolean increaseRunTimesByScriptId(Long ScriptId);

    /**
     * 获得所有剧本
     *
     * @return 剧本的视图类数组
     */
    List<ScriptVo> getAllScripts();

//    List<Script> getAllScriptsBySceneId(Long sceneId);

    List<Script> getScriptsInPage(Long pageNum, Long pageSize);

    Long getScriptsTotal();
}
