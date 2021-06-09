package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.Scene;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 场景区模型接口
 *
 * @author xiaov
 * @since 2021-05-21 15:24
 */
@Mapper
public interface SceneMapper {

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
