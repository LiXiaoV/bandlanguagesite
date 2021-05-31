package com.bandlanguage.bandlanguagesite.service;

import com.bandlanguage.bandlanguagesite.model.vo.NodeVo;

import java.util.List;

/**
 * 节点的服务类
 * @author xiaov
 * @since 2021-05-31 14:41
 */
public interface NodeService {

    /**
     * 保存节点
     * @param nodeVo 节点的视图类
     * @return 是否成功
     */
    Boolean saveNode(NodeVo nodeVo);

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
