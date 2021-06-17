package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.Node;
import com.bandlanguage.bandlanguagesite.model.vo.NodeVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 节点模型类
 *
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

    /**
     * 获得与某个词汇关联的所有节点
     *
     * @param wordId 词汇ID
     * @return 节点的视图类数组
     */
    List<NodeVo> getWordAssociatedNodesByWordId(Long wordId);

    /**
     * 获得与某个句型关联的所有节点
     *
     * @param sentenceId 句型ID
     * @return 节点的视图类数组
     */
    List<NodeVo> getSentenceAssociatedNodesBySentenceId(Long sentenceId);
}
