package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.Scene;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 场景区模型接口
 *
 * @author xiaov
 * @since 2021-05-21 15:24
 */
@Mapper
public interface SceneMapper extends BaseMapper<Scene> {

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
}
