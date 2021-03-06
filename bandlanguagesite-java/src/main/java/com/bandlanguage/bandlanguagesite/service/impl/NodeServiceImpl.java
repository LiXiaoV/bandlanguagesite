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
        // 插入节点
        Node node = Node.builder().name(nodeVo.getName())
                .packageName(nodeVo.getPackageName())
                .content(nodeVo.getContent())
                .creatorId(nodeVo.getUserId())
                .editorId(nodeVo.getUserId())
                .updateTime(new Date()).build();
        int insertNodeCount = nodeMapper.insert(node);
        if (insertNodeCount <= 0)
            throw new GlobalException(ResultCode.SAVE_NODE_FAIL);

        // 插入场景区与节点的关联
        SceneNode sceneNode = SceneNode.builder().sceneId(nodeVo.getSceneId())
                .nodeId(node.getNodeId()).build();
        int insertSceneNodeCount = sceneNodeMapper.insert(sceneNode);
        if (insertSceneNodeCount <= 0)
            throw new GlobalException(ResultCode.SAVE_SCENE_NODE_FAIL);

        // 插入用户与节点的关联
        NodeUser nodeUser = NodeUser.builder().nodeId(node.getNodeId())
                .userId(nodeVo.getUserId())
                .updateTime(new Date()).build();
        int insertNodeUserCount = nodeUserMapper.insert(nodeUser);
        if (insertNodeUserCount <= 0)
            throw new GlobalException(ResultCode.SAVE_NODE_USER_FAIL);

        // 插入节点与词汇句型的关联
        if (nodeVo.getType() == 1) {
            // 插入节点与词汇的关联
            WordNode wordNode = WordNode.builder().wordId(nodeVo.getItemId())
                    .nodeId(node.getNodeId()).build();

            int insertWordNodeCount = wordNodeMapper.insert(wordNode);
            if (insertWordNodeCount <= 0)
                throw new GlobalException(ResultCode.SAVE_WORD_NODE_FAIL);
        } else if (nodeVo.getType() == 2) {
            // 插入节点与句型的关联
            SentenceNode sentenceNode = SentenceNode.builder().sentenceId(nodeVo.getItemId())
                    .nodeId(node.getNodeId()).build();

            int insertSentenceNodeCount = sentenceNodeMapper.insert(sentenceNode);
            if (insertSentenceNodeCount <= 0)
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
        int updateNodeCount = nodeMapper.updateById(node);
        if (updateNodeCount <= 0)
            throw new GlobalException(ResultCode.UPDATE_NODE_FAIL);

        // 查询此用户是否修改或创建过这个节点，如果是，则跟新时间，如果不是，则插入记录
        QueryWrapper<NodeUser> nodeUserQueryWrapper = new QueryWrapper<>();
        nodeUserQueryWrapper.eq("user_id", nodeVo.getUserId());
        nodeUserQueryWrapper.eq("node_id", nodeVo.getNodeId());
        NodeUser nodeUser = nodeUserMapper.selectOne(nodeUserQueryWrapper);
        if (nodeUser != null) {
            nodeUser.setUpdateTime(new Date());
            int updateNodeUserCount = nodeUserMapper.updateById(nodeUser);
            if (updateNodeUserCount <= 0)
                throw new GlobalException(ResultCode.UPDATE_NODE_USER_FAIL);
        } else {
            NodeUser insertNodeUser = NodeUser.builder().nodeId(nodeVo.getNodeId())
                    .userId(nodeVo.getUserId())
                    .updateTime(new Date()).build();
            int insertNodeUserCount = nodeUserMapper.insert(insertNodeUser);
            if (insertNodeUserCount <= 0)
                throw new GlobalException(ResultCode.SAVE_NODE_USER_FAIL);
        }

        // 在某个词汇或句型的开发窗口里面修改节点
        // 查询该词汇或句型是否与这个节点关联，如果没有关联，则关联，如果已经关联，则不用做处理
        if (nodeVo.getType() == 1) {  // 词汇
            // 查看节点与词汇是否有关联，没有就插入
            QueryWrapper<WordNode> wordNodeQueryWrapper = new QueryWrapper<>();
            wordNodeQueryWrapper.eq("word_id", nodeVo.getItemId());
            wordNodeQueryWrapper.eq("node_id", nodeVo.getNodeId());
            WordNode wordNode = wordNodeMapper.selectOne(wordNodeQueryWrapper);
            if (wordNode == null) {
                WordNode insertWordNode = WordNode.builder().wordId(nodeVo.getItemId())
                        .nodeId(node.getNodeId()).build();
                int insertWordNodeCount = wordNodeMapper.insert(insertWordNode);
                if (insertWordNodeCount <= 0)
                    throw new GlobalException(ResultCode.SAVE_WORD_NODE_FAIL);
            } else if (wordNode.getStatus() == 0) {    // 已删除就恢复
                wordNode.setStatus(1);
                int updateWordNodeCnt = wordNodeMapper.updateById(wordNode);
                if (updateWordNodeCnt <= 0)
                    throw new GlobalException(ResultCode.UPDATE_WORD_NODE_FAIL);
            }
        } else if (nodeVo.getType() == 2) {    // 句型
            // 查看节点与句型是否有关联，没有就插入
            QueryWrapper<SentenceNode> sentenceNodeQueryWrapper = new QueryWrapper<>();
            sentenceNodeQueryWrapper.eq("sentence_id", nodeVo.getItemId());
            sentenceNodeQueryWrapper.eq("node_id", nodeVo.getNodeId());
            SentenceNode sentenceNode = sentenceNodeMapper.selectOne(sentenceNodeQueryWrapper);
            if (sentenceNode == null) {
                SentenceNode insertSentenceNode = SentenceNode.builder().sentenceId(nodeVo.getItemId())
                        .nodeId(node.getNodeId()).build();
                int insertSentenceNodeCount = sentenceNodeMapper.insert(insertSentenceNode);
                if (insertSentenceNodeCount <= 0)
                    throw new GlobalException(ResultCode.SAVE_SENTENCE_NODE_FAIL);
            } else if (sentenceNode.getStatus() == 0) {    // 已删除就恢复
                sentenceNode.setStatus(1);
                int updateSentenceNodeCnt = sentenceNodeMapper.updateById(sentenceNode);
                if (updateSentenceNodeCnt <= 0)
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
    @Transactional
    public Boolean deleteNodeOfAssociate(NodeVo nodeVo) {
        // 先在node里面把修改者改了
        Node node = Node.builder().nodeId(nodeVo.getNodeId())
                .editorId(nodeVo.getEditorId())
                .updateTime(new Date()).build();
        int updateNodeCnt = nodeMapper.updateById(node);
        if (updateNodeCnt <= 0)
            throw new GlobalException(ResultCode.UPDATE_NODE_FAIL);

        // 修改节点-词汇或句型表的status
        if (nodeVo.getType() == 1) {  // 词汇
            // 节点与词汇
            UpdateWrapper<WordNode> wordNodeUpdateWrapper = new UpdateWrapper<>();
            wordNodeUpdateWrapper.eq("word_id", nodeVo.getItemId())
                    .eq("node_id", nodeVo.getNodeId()).set("status", 0);
            int deleteWordNodeCnt = wordNodeMapper.update(null, wordNodeUpdateWrapper);
            if (deleteWordNodeCnt <= 0)
                throw new GlobalException(ResultCode.DELETE_WORD_NODE_FAIL);
        } else if (nodeVo.getType() == 2) {    // 句型
            // 节点与句型
            UpdateWrapper<SentenceNode> sentenceNodeUpdateWrapper = new UpdateWrapper<>();
            sentenceNodeUpdateWrapper.eq("sentence_id", nodeVo.getItemId())
                    .eq("node_id", nodeVo.getNodeId()).set("status", 0);
            int deleteSentenceNodeCnt = sentenceNodeMapper.update(null, sentenceNodeUpdateWrapper);
            if (deleteSentenceNodeCnt <= 0)
                throw new GlobalException(ResultCode.DELETE_SENTENCE_NODE_FAIL);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteNode(NodeVo nodeVo) {
        // 1. 根据节点ID查找节点要删除的节点是否存在
        if (nodeVo.getNodeId() <= 0 || nodeVo.getNodeId() == null)
            throw new GlobalException(ResultCode.DELETE_NODE_NOT_EXIST);
        Node node = nodeMapper.selectById(nodeVo.getNodeId());
        if (node == null || node.getStatus() == 0)
            throw new GlobalException(ResultCode.DELETE_NODE_NOT_EXIST);

        // 2. 修改节点状态和修改者的用户ID和修改时间
        node.setStatus(0);
        node.setEditorId(nodeVo.getUserId());
        node.setUpdateTime(new Date());
        int deleteCnt = nodeMapper.updateById(node);
        if (deleteCnt <= 0)
            throw new GlobalException(ResultCode.DELETE_NODE_FAIL);

        // 3. 删除场景区-节点的关联(必定有记录)
        UpdateWrapper<SceneNode> sceneNodeUpdateWrapper = new UpdateWrapper<>();
        sceneNodeUpdateWrapper.eq("node_id", nodeVo.getNodeId())
                .set("status", 0);
        int deleteSceneNodeCount = sceneNodeMapper.update(null, sceneNodeUpdateWrapper);
        if (deleteSceneNodeCount <= 0)
            throw new GlobalException(ResultCode.DELETE_SCENE_NODE_FAIL);

        // 4. 在节点-用户表里设置删除状态(必定有记录)
        UpdateWrapper<NodeUser> nodeUserUpdateWrapper = new UpdateWrapper<>();
        nodeUserUpdateWrapper.eq("node_id", nodeVo.getNodeId())
                .set("status", 0);
        int deleteNodeUserCount = nodeUserMapper.update(null, nodeUserUpdateWrapper);
        if (deleteNodeUserCount <= 0)
            throw new GlobalException(ResultCode.DELETE_NODE_USER_FAIL);

        // 5. 在节点-词汇表里设置删除状态(可能没有词汇与节点关联)
        QueryWrapper<WordNode> wordNodeQueryWrapper = new QueryWrapper<>();
        wordNodeQueryWrapper.eq("node_id", nodeVo.getNodeId());
        wordNodeQueryWrapper.gt("status", 0);
        Integer needDeleteWordNodeCount = wordNodeMapper.selectCount(wordNodeQueryWrapper);

        UpdateWrapper<WordNode> wordNodeUpdateWrapper = new UpdateWrapper<>();
        wordNodeUpdateWrapper.eq("node_id", nodeVo.getNodeId())
                .gt("status", 0)
                .set("status", 0);
        int deleteWordNodeCount = wordNodeMapper.update(null, wordNodeUpdateWrapper);
        if (needDeleteWordNodeCount != deleteWordNodeCount)
            throw new GlobalException(ResultCode.DELETE_WORD_NODE_FAIL);

        // 6. 在节点-句型表里设置删除状态
        QueryWrapper<SentenceNode> sentenceNodeQueryWrapper = new QueryWrapper<>();
        sentenceNodeQueryWrapper.eq("node_id", nodeVo.getNodeId());
        sentenceNodeQueryWrapper.gt("status", 0);
        Integer needDeleteSentenceNodeCount = sentenceNodeMapper.selectCount(sentenceNodeQueryWrapper);

        UpdateWrapper<SentenceNode> sentenceNodeUpdateWrapper = new UpdateWrapper<>();
        sentenceNodeUpdateWrapper.eq("node_id", nodeVo.getNodeId())
                .gt("status", 0).set("status", 0);
        int deleteSentenceNodeCount = sentenceNodeMapper.update(null, sentenceNodeUpdateWrapper);
        if (needDeleteSentenceNodeCount != deleteSentenceNodeCount)
            throw new GlobalException(ResultCode.DELETE_SENTENCE_NODE_FAIL);
        return true;
    }
}
