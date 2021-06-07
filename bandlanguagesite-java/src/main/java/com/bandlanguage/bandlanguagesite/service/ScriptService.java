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
     * @param scriptVo 剧本的输入实体类
     * @return 保存是否成功
     */
    Boolean SaveScript(ScriptVo scriptVo);

    /**
     * 通过场景区Id获取所有剧本
     * @param sceneId 场景区ID
     * @return 剧本对象数组
     */
    List<Script> getAllScriptsBySceneId(Long sceneId);

    List<Script> getScriptsInPage(Long pageNum,Long pageSize);

    Long getScriptsTotal();
}
