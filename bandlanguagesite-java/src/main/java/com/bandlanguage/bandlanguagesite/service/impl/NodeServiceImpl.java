package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.mapper.NodeMapper;
import com.bandlanguage.bandlanguagesite.mapper.NodeUserMapper;
import com.bandlanguage.bandlanguagesite.mapper.SceneNodeMapper;
import com.bandlanguage.bandlanguagesite.model.entity.Node;
import com.bandlanguage.bandlanguagesite.model.entity.NodeUser;
import com.bandlanguage.bandlanguagesite.model.entity.SceneNode;
import com.bandlanguage.bandlanguagesite.model.vo.NodeVo;
import com.bandlanguage.bandlanguagesite.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xiaov
 * @since 2021-05-31 14:45
 */
@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeMapper nodeMapper;

    @Autowired
    private SceneNodeMapper sceneNodeMapper;

    @Autowired
    private NodeUserMapper nodeUserMapper;

    @Override
    public Boolean saveNode(NodeVo nodeVo) {
        Node node = Node.builder().name(nodeVo.getName())
                .packageName(nodeVo.getPackageName())
                .content(nodeVo.getContent())
                .creatorId(nodeVo.getUserId())
                .editorId(nodeVo.getUserId())
                .updateTime(new Date()).build();
        int cnt = nodeMapper.insert(node);
        if(cnt > 0){
            // 插入场景区与节点的关联
            SceneNode sceneNode = SceneNode.builder().sceneId(nodeVo.getSceneId())
                    .nodeId(node.getNodeId()).build();
            int cnt1 = sceneNodeMapper.insert(sceneNode);

            // 插入用户与节点的关联
            NodeUser nodeUser = NodeUser.builder().nodeId(node.getNodeId())
                    .userId(nodeVo.getUserId())
                    .updateTime(new Date()).build();
            int cnt2 = nodeUserMapper.insert(nodeUser);
            return cnt1 > 0 && cnt2 > 0;
        }
        return false;
    }

    @Override
    public List<NodeVo> getAllSimpleNodesBySceneId(Long sceneId) {
        return nodeMapper.getAllSimpleNodesBySceneId(sceneId);
    }

    @Override
    public List<NodeVo> getAllWholeNodesBySceneId(Long sceneId) {
        return nodeMapper.getAllWholeNodesBySceneId(sceneId);
    }
}
