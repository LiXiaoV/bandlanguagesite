package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.Node;
import com.bandlanguage.bandlanguagesite.model.vo.NodeVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 节点模型类
 * @author xiaov
 * @since 2021-05-31 11:26
 */
@Mapper
public interface NodeMapper extends BaseMapper<Node> {

    /**
     * 通过场景区获取所有节点--简单信息
     *
     * @param sceneId 场景区ID
     * @return NodeVo对象数组
     */
    List<NodeVo> getAllSimpleNodesBySceneId(Long sceneId);

    /**
     * 通过场景区获取所有节点--完整信息
     *
     * @param sceneId 场景区ID
     * @return NodeVo对象数组
     */
    List<NodeVo> getAllWholeNodesBySceneId(Long sceneId);
}
