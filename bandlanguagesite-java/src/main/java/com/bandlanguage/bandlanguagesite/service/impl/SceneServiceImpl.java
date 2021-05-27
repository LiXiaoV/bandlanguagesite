package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.model.entity.Scene;
import com.bandlanguage.bandlanguagesite.mapper.SceneMapper;
import com.bandlanguage.bandlanguagesite.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
