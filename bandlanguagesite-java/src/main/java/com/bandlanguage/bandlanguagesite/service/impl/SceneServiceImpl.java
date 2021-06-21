package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.SceneMapper;
import com.bandlanguage.bandlanguagesite.model.entity.Scene;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-21 15:46
 */
@Service
public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneMapper sceneMapper;

    @Override
    public List<Scene> getScenes() {
        return sceneMapper.getScenes();
    }

    @Override
    public Scene getSceneById(Long id) {
        return sceneMapper.getSceneById(id);
    }

    @Override
    public List<Scene> getHotScenes(Long limitCount) {
        return sceneMapper.getHotScenes(limitCount);
    }

    @Override
    @Transactional
    public Boolean SaveScene(Scene scene) {
        scene.setCreateTime(new Date());
        scene.setBandObjId(0L);
        scene.setParentId(0L);
        int res = sceneMapper.insert(scene);
        if (res <= 0)
            throw new GlobalException(ResultCode.SAVE_SCENE_FAIL);
        return true;
    }
}
