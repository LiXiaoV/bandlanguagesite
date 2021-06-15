package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.SceneScriptMapper;
import com.bandlanguage.bandlanguagesite.mapper.ScriptMapper;
import com.bandlanguage.bandlanguagesite.mapper.ScriptUserMapper;
import com.bandlanguage.bandlanguagesite.mapper.UserMapper;
import com.bandlanguage.bandlanguagesite.model.entity.SceneScript;
import com.bandlanguage.bandlanguagesite.model.entity.Script;
import com.bandlanguage.bandlanguagesite.model.entity.ScriptUser;
import com.bandlanguage.bandlanguagesite.model.entity.User;
import com.bandlanguage.bandlanguagesite.model.vo.ScriptVo;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.ScriptService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    @Autowired
    private ScriptUserMapper scriptUserMapper;

    @Autowired
    private UserMapper userMapper;

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
        if (res <= 0)
            throw new GlobalException(ResultCode.SAVE_SCRIPT_FAIL);

        SceneScript sceneScript = SceneScript.builder().sceneId(scriptVo.getSceneId())
                .scriptId(script.getScriptId()).build();
        int res1 = sceneScriptMapper.insert(sceneScript);
        if (res1 <= 0)
            throw new GlobalException(ResultCode.SAVE_SCENE_SCRIPT_FAIL);

        ScriptUser scriptUser = ScriptUser.builder().scriptId(script.getScriptId())
                .userId(scriptVo.getUserId())
                .updateTime(new Date()).build();
        int res2 = scriptUserMapper.insert(scriptUser);
        if (res2 <= 0)
            throw new GlobalException(ResultCode.SAVE_SCRIPT_USER_FAIL);

        return true;
    }

    @Override
    public List<ScriptVo> getAllScriptsBySceneId(Long sceneId) {
        return scriptMapper.getAllScriptsBySceneId(sceneId);
    }

    @Override

    public List<ScriptVo> getMyScriptsBySceneIdAndUserId(Long sceneId, Long userId) {
        return scriptMapper.getMyScriptsBySceneIdAndUserId(sceneId, userId);
    }

    @Override
    public ScriptVo getMyScriptDetailById(Long scriptId) {
        Script script = scriptMapper.selectById(scriptId);
        if (script == null)
            throw new GlobalException(ResultCode.SELECT_SCRIPT_NOT_EXIST);

        User creator = userMapper.selectById(script.getCreatorId());
        User editor = userMapper.selectById(script.getEditorId());
        return ScriptVo.builder().scriptId(script.getScriptId())
                .name(script.getName())
                .content(script.getContent())
                .description(script.getDescription())
                .creatorId(script.getCreatorId())
                .creatorUsername(creator.getUsername())
                .creatorNickname(creator.getNickname())
                .editorId(script.getEditorId())
                .editorUsername(editor.getUsername())
                .editorNickname(editor.getNickname())
                .updateTime(script.getUpdateTime())
                .runTimes(script.getRunTimes()).build();
    }

    @Override
    @Transactional
    public Boolean editScript(ScriptVo scriptVo) {
        Script script = Script.builder().scriptId(scriptVo.getScriptId())
                .name(scriptVo.getName())
                .content(scriptVo.getContent())
                .description(scriptVo.getDescription())
                .editorId(scriptVo.getUserId())
                .updateTime(new Date()).build();
        int cnt = scriptMapper.updateById(script);
        if (cnt <= 0)
            throw new GlobalException(ResultCode.EDIT_SCRIPT_FAIL);

        // 查询此用户是否修改或创建过这个句型，如果是，则更新时间，如果不是，则插入记录
        QueryWrapper<ScriptUser> scriptUserQueryWrapper = new QueryWrapper<>();
        scriptUserQueryWrapper.eq("user_id", scriptVo.getUserId());
        scriptUserQueryWrapper.eq("script_id", scriptVo.getScriptId());
        ScriptUser scriptUser = scriptUserMapper.selectOne(scriptUserQueryWrapper);

        if (scriptUser != null) {
            scriptUser.setUpdateTime(new Date());
            int editCount = scriptUserMapper.updateById(scriptUser);
            if (editCount <= 0)
                throw new GlobalException(ResultCode.UPDATE_SCRIPT_USER_FAIL);
        } else {
            ScriptUser insertScriptUser = ScriptUser.builder().scriptId(scriptVo.getScriptId())
                    .userId(scriptVo.getUserId())
                    .updateTime(new Date()).build();
            int insertCount = scriptUserMapper.insert(insertScriptUser);
            if (insertCount <= 0)
                throw new GlobalException(ResultCode.SAVE_SCRIPT_USER_FAIL);
        }
        return true;
    }

    @Override
    public Boolean deleteScriptById(Long scriptId) {
        Script script = scriptMapper.selectById(scriptId);
        if (script == null)
            throw new GlobalException(ResultCode.DELETE_SCRIPT_NOT_EXIST);

        script.setStatus(0);

        // 更新剧本状态，肯定有记录要修改
        int cnt1 = scriptMapper.updateById(script);
        if (cnt1 <= 0)
            throw new GlobalException(ResultCode.EDIT_SCRIPT_FAIL);

        // 更新剧本-场景区关联表，肯定有记录要修改
        UpdateWrapper<SceneScript> sceneScriptUpdateWrapper = new UpdateWrapper<>();
        sceneScriptUpdateWrapper.eq("script_id", script.getScriptId()).set("status", 0);
        int cnt2 = sceneScriptMapper.update(null, sceneScriptUpdateWrapper);
        if (cnt2 <= 0)
            throw new GlobalException(ResultCode.UPDATE_SCENE_SCRIPT_FAIL);

        // 更新剧本-用户关联表，肯定有记录要修改
        UpdateWrapper<ScriptUser> scriptUserUpdateWrapper = new UpdateWrapper<>();
        scriptUserUpdateWrapper.eq("script_id", script.getScriptId()).set("status", 0);
        int cnt3 = scriptUserMapper.update(null, scriptUserUpdateWrapper);
        if (cnt3 <= 0)
            throw new GlobalException(ResultCode.UPDATE_SCRIPT_USER_FAIL);

        return true;
    }

    @Override
    public List<ScriptVo> getHotScripts(Long limitCount) {
        return scriptMapper.getHotScripts(limitCount);
    }

    @Override
    public Boolean increaseRunTimesByScriptId(Long ScriptId) {
        Script script = scriptMapper.selectById(ScriptId);
        if (script == null)
            throw new GlobalException(ResultCode.EDIT_SCRIPT_NOT_EXIST);

        script.setRunTimes(script.getRunTimes() + 1);
        int res = scriptMapper.updateById(script);
        if (res <= 0)
            throw new GlobalException(ResultCode.INCREASE_SCRIPT_RUNTIMES_FAIL);
        return true;
    }

    @Override
    public List<ScriptVo> getAllScripts() {
        return scriptMapper.getAllScripts();
    }

    public List<Script> getScriptsInPage(Long pageNum, Long pageSize) {

        return scriptMapper.getAllScriptsInPage((pageNum - 1) * pageSize, pageSize);
    }

    @Override
    public Long getScriptsTotal() {
        return scriptMapper.getScriptsTotal();
    }
}
