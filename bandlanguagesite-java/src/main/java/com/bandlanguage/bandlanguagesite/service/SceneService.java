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

    /**
     * 获取火热的场景区（暂时按获取ID前几个，后面可以修改为在某一段时间进去的人数的数量来排序）
     *
     * @param limitCount 获取的数量
     * @return 场景区对象数组
     */
    List<Scene> getHotScenes(Long limitCount);

    /**
     * 新增场景区
     *
     * @param scene 场景区实体类
     * @return 增加是否成功
     */
    Boolean SaveScene(Scene scene);
}
