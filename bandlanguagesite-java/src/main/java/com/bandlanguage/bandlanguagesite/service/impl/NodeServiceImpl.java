package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.*;
import com.bandlanguage.bandlanguagesite.model.entity.*;
import com.bandlanguage.bandlanguagesite.model.vo.NodeVo;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.NodeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
        if (nodeVo.getType() == 1) {
            // 插入节点与词汇的关联
            WordNode wordNode = WordNode.builder().wordId(nodeVo.getItemId())
                    .nodeId(node.getNodeId()).build();

            int cnt3 = wordNodeMapper.insert(wordNode);
            if (cnt3 <= 0)
                throw new GlobalException(ResultCode.SAVE_WORD_NODE_FAIL);
        } else if (nodeVo.getType() == 2) {
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
            throw new GlobalException(ResultCode.UPDATE_NODE_FAIL);

        // 查询此用户是否修改或创建过这个节点，如果是，则跟新时间，如果不是，则插入记录
        QueryWrapper<NodeUser> nodeUserQueryWrapper = new QueryWrapper<>();
        nodeUserQueryWrapper.eq("user_id", nodeVo.getUserId());
        nodeUserQueryWrapper.eq("node_id", nodeVo.getNodeId());
        NodeUser nodeUser = nodeUserMapper.selectOne(nodeUserQueryWrapper);
        int cnt1;
        if (nodeUser != null) {
            nodeUser.setUpdateTime(new Date());
            cnt1 = nodeUserMapper.updateById(nodeUser);
            if(cnt1 <= 0)
                throw new GlobalException(ResultCode.UPDATE_NODE_USER_FAIL);
        } else {
            NodeUser insertNodeUser = NodeUser.builder().nodeId(nodeVo.getNodeId())
                    .userId(nodeVo.getUserId())
                    .updateTime(new Date()).build();
            cnt1 = nodeUserMapper.insert(insertNodeUser);
            if(cnt1 <= 0)
                throw new GlobalException(ResultCode.SAVE_NODE_USER_FAIL);
        }

        // 查询该词汇或句型是否与这个规则关联，如果没有关联，则关联，如果已经关联，则不用做处理
        if(nodeVo.getType() == 1){
            // 查看节点与词汇是否有关联，没有就插入
            QueryWrapper<WordNode> wordNodeQueryWrapper = new QueryWrapper<>();
            wordNodeQueryWrapper.eq("word_id",nodeVo.getItemId());
            wordNodeQueryWrapper.eq("node_id",nodeVo.getNodeId());
            WordNode wordNode = wordNodeMapper.selectOne(wordNodeQueryWrapper);
            if(wordNode == null){
                WordNode insertWordNode = WordNode.builder().wordId(nodeVo.getItemId())
                        .nodeId(node.getNodeId()).build();
                int cnt2 = wordNodeMapper.insert(insertWordNode);
                if(cnt2 <= 0)
                    throw new GlobalException(ResultCode.SAVE_WORD_NODE_FAIL);
            }else if(wordNode.getStatus() == 0){    // 已删除就恢复
                wordNode.setStatus(1);
                int updateCnt = wordNodeMapper.updateById(wordNode);
                if(updateCnt <= 0)
                    throw new GlobalException(ResultCode.UPDATE_WORD_NODE_FAIL);
            }
        }else if(nodeVo.getType() == 2){
            // 查看节点与句型是否有关联，没有就插入
            QueryWrapper<SentenceNode> sentenceNodeQueryWrapper = new QueryWrapper<>();
            sentenceNodeQueryWrapper.eq("sentence_id",nodeVo.getItemId());
            sentenceNodeQueryWrapper.eq("node_id",nodeVo.getNodeId());
            SentenceNode sentenceNode = sentenceNodeMapper.selectOne(sentenceNodeQueryWrapper);
            if(sentenceNode == null){
                SentenceNode insertSentenceNode = SentenceNode.builder().sentenceId(nodeVo.getItemId())
                        .nodeId(node.getNodeId()).build();
                int cnt3 = sentenceNodeMapper.insert(insertSentenceNode);
                if(cnt3 <= 0)
                    throw new GlobalException(ResultCode.SAVE_SENTENCE_NODE_FAIL);
            }else if(sentenceNode.getStatus() == 0){    // 已删除就恢复
                sentenceNode.setStatus(1);
                int updateCnt = sentenceNodeMapper.updateById(sentenceNode);
                if(updateCnt <= 0)
                    throw new GlobalException(ResultCode.UPDATE_SENTENCE_NODE_FAIL);
            }
        }
        return true;
    }

    @Override
    public List<NodeVo> getWordAssociatedNodesByWordId(Long wordId) {
        return nodeMapper.getWordAssociatedNodesByWordId(wordId);
    }

    @Override
    public List<NodeVo> getSentenceAssociatedNodesBySentenceId(Long sentenceId) {
        return nodeMapper.getSentenceAssociatedNodesBySentenceId(sentenceId);
    }

    @Override
    public Boolean deleteNodeOfAssociate(NodeVo nodeVo) {
        // 先在node里面把修改者改了
        Node node = Node.builder().nodeId(nodeVo.getNodeId())
                .editorId(nodeVo.getEditorId())
                .updateTime(new Date()).build();
        int updateCnt = nodeMapper.updateById(node);
        if(updateCnt <= 0)
            throw new GlobalException(ResultCode.UPDATE_NODE_FAIL);

        // 修改节点-词汇或句型表的status
        if(nodeVo.getType() == 1){
            // 节点与词汇
            UpdateWrapper<WordNode> wordNodeUpdateWrapper = new UpdateWrapper<>();
            wordNodeUpdateWrapper.eq("word_id",nodeVo.getItemId())
                    .eq("node_id",nodeVo.getNodeId()).set("status",0);
            int deleteCnt = wordNodeMapper.update(null, wordNodeUpdateWrapper);
            if(deleteCnt <= 0)
                throw new GlobalException(ResultCode.DELETE_WORD_NODE_FAIL);
        }else if(nodeVo.getType() == 2){
            // 节点与句型
            UpdateWrapper<SentenceNode> sentenceNodeUpdateWrapper = new UpdateWrapper<>();
            sentenceNodeUpdateWrapper.eq("sentence_id",nodeVo.getItemId())
                    .eq("node_id",nodeVo.getNodeId()).set("status",0);
            int deleteCnt = sentenceNodeMapper.update(null, sentenceNodeUpdateWrapper);
            if(deleteCnt <= 0)
                throw new GlobalException(ResultCode.DELETE_SENTENCE_NODE_FAIL);
        }
        return true;
    }
}
