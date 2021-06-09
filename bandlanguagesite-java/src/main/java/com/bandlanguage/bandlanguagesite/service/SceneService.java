package com.bandlanguage.bandlanguagesite.service;

import com.bandlanguage.bandlanguagesite.model.entity.Scene;

import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-21 15:43
 */
public interface SceneService {

    /**
     * 获取所有场景区
     *
     * @return 场景区的对象list
     */
    List<Scene> getScenes();

    /**
     * 根据id查询场景区
     *
     * @param id 场景区id
     * @return 查询的场景区对象
     */
    Scene getSceneById(Long id);

    List<Scene> getScenesByKeyword(String keyword);
}
