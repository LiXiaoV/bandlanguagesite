package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.mapper.SceneScriptMapper;
import com.bandlanguage.bandlanguagesite.mapper.ScriptMapper;
import com.bandlanguage.bandlanguagesite.model.entity.SceneScript;
import com.bandlanguage.bandlanguagesite.model.entity.Script;
import com.bandlanguage.bandlanguagesite.model.vo.ScriptVo;
import com.bandlanguage.bandlanguagesite.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-24 02:01
 */
@Service
public class ScriptServiceImpl implements ScriptService {

    @Autowired
    private SceneScriptMapper sceneScriptMapper;

    @Autowired
    private ScriptMapper scriptMapper;

    @Override
    @Transactional
    public Boolean SaveScript(ScriptVo scriptVo) {
        Script script = Script.builder().name(scriptVo.getName())
                .content(scriptVo.getContent())
                .description(scriptVo.getDescription())
                .creatorId(scriptVo.getUserId())
                .editorId(scriptVo.getUserId())
                .updateTime(new Date()).build();
        int res = scriptMapper.insert(script);
        if (res > 0) {
            SceneScript sceneScript = SceneScript.builder().sceneId(scriptVo.getSceneId())
                    .scriptId(script.getScriptId()).build();
            int res1 = sceneScriptMapper.insert(sceneScript);
            return res1 > 0;
        }
        return false;
    }

    @Override
    public List<Script> getAllScriptsBySceneId(Long sceneId) {
        return scriptMapper.getAllScriptsBySceneId(sceneId);
    }
}
