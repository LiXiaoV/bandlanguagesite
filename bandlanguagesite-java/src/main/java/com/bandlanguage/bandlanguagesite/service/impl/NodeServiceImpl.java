package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.*;
import com.bandlanguage.bandlanguagesite.model.entity.*;
import com.bandlanguage.bandlanguagesite.model.vo.NodeVo;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.NodeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WordNodeMapper wordNodeMapper;

    @Autowired
    private SentenceNodeMapper sentenceNodeMapper;

    @Override
    @Transactional
    public Boolean saveNode(NodeVo nodeVo) {
        Node node = Node.builder().name(nodeVo.getName())
                .packageName(nodeVo.getPackageName())
                .content(nodeVo.getContent())
                .creatorId(nodeVo.getUserId())
                .editorId(nodeVo.getUserId())
                .updateTime(new Date()).build();
        int cnt = nodeMapper.insert(node);
        if (cnt <= 0)
            throw new GlobalException(ResultCode.SAVE_NODE_FAIL);

        // 插入场景区与节点的关联
        SceneNode sceneNode = SceneNode.builder().sceneId(nodeVo.getSceneId())
                .nodeId(node.getNodeId()).build();
        int cnt1 = sceneNodeMapper.insert(sceneNode);
        if (cnt1 <= 0)
            throw new GlobalException(ResultCode.SAVE_SCENE_NODE_FAIL);

        // 插入用户与节点的关联
        NodeUser nodeUser = NodeUser.builder().nodeId(node.getNodeId())
                .userId(nodeVo.getUserId())
                .updateTime(new Date()).build();
        int cnt2 = nodeUserMapper.insert(nodeUser);
        if (cnt2 <= 0)
            throw new GlobalException(ResultCode.SAVE_NODE_USER_FAIL);

        // 插入节点与词汇句型的关联
        if (nodeVo.getType() == 0) {
            // 插入节点与词汇的关联
            WordNode wordNode = WordNode.builder().wordId(nodeVo.getItemId())
                    .nodeId(node.getNodeId()).build();

            int cnt3 = wordNodeMapper.insert(wordNode);
            if (cnt3 <= 0)
                throw new GlobalException(ResultCode.SAVE_WORD_NODE_FAIL);
        } else if (nodeVo.getType() == 1) {
            // 插入节点与句型的关联
            SentenceNode sentenceNode = SentenceNode.builder().sentenceId(nodeVo.getItemId())
                    .nodeId(node.getNodeId()).build();

            int cnt4 = sentenceNodeMapper.insert(sentenceNode);
            if (cnt4 <= 0)
                throw new GlobalException(ResultCode.SAVE_SENTENCE_NODE_FAIL);
        }

        return true;
    }

    @Override
    public List<NodeVo> getAllSimpleNodesBySceneId(Long sceneId) {
        return nodeMapper.getAllSimpleNodesBySceneId(sceneId);
    }

    @Override
    public List<NodeVo> getAllWholeNodesBySceneId(Long sceneId) {
        return nodeMapper.getAllWholeNodesBySceneId(sceneId);
    }

    @Override
    public NodeVo getNodeDetailById(Long nodeId) {
        Node node = nodeMapper.selectById(nodeId);
        if (node == null)
            throw new GlobalException(ResultCode.SELECT_NODE_NOT_EXIST);
        User creator = userMapper.selectById(node.getCreatorId());
        User editor = userMapper.selectById(node.getEditorId());
        return NodeVo.builder().nodeId(node.getNodeId())
                .name(node.getName())
                .packageName(node.getPackageName())
                .content(node.getContent())
                .creatorId(node.getCreatorId())
                .creatorUsername(creator.getUsername())
                .creatorNickname(creator.getNickname())
                .editorId(node.getEditorId())
                .editorUsername(editor.getUsername())
                .editorNickname(editor.getNickname())
                .updateTime(node.getUpdateTime())
                .status(node.getStatus()).build();
    }

    @Override
    @Transactional
    public Boolean editNode(NodeVo nodeVo) {
        Node node = Node.builder().nodeId(nodeVo.getNodeId())
                .name(nodeVo.getName())
                .packageName(nodeVo.getPackageName())
                .content(nodeVo.getContent())
                .editorId(nodeVo.getUserId())
                .updateTime(new Date()).build();
        int cnt = nodeMapper.updateById(node);
        if (cnt <= 0)
            throw new GlobalException(ResultCode.EDIT_NODE_FAIL);

        // 查询此用户是否修改或创建过这个节点，如果是，则跟新时间，如果不是，则插入记录
        QueryWrapper<NodeUser> nodeUserQueryWrapper = new QueryWrapper<>();
        nodeUserQueryWrapper.eq("user_id", nodeVo.getUserId());
        nodeUserQueryWrapper.eq("node_id", nodeVo.getNodeId());
        NodeUser nodeUser = nodeUserMapper.selectOne(nodeUserQueryWrapper);
        int cnt1;
        if (nodeUser != null) {
            nodeUser.setUpdateTime(new Date());
            cnt1 = nodeUserMapper.updateById(nodeUser);
        } else {
            NodeUser insertNodeUser = NodeUser.builder().nodeId(nodeVo.getNodeId())
                    .userId(nodeVo.getUserId())
                    .updateTime(new Date()).build();
            cnt1 = nodeUserMapper.insert(insertNodeUser);
        }
        return cnt1 > 0;
    }
}
