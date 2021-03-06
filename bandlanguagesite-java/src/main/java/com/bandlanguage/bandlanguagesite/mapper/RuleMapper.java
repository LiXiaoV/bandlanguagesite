package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.Rule;
import com.bandlanguage.bandlanguagesite.model.vo.RuleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 规则模型类
 *
 * @author xiaov
 * @since 2021-05-31 11:14
 */
@Mapper
public interface RuleMapper extends BaseMapper<Rule> {

    /**
     * 通过场景区获取所有规则--简单信息
     *
     * @param sceneId 场景区ID
     * @return RuleVo对象数组
     */
    List<RuleVo> getAllSimpleRulesBySceneId(Long sceneId);

    /**
     * 通过场景区获取所有规则--完整信息
     *
     * @param sceneId 场景区ID
     * @return RuleVo对象数组
     */
    List<RuleVo> getAllWholeRulesBySceneId(Long sceneId);

    /**
     * 获得与某个词汇关联的所有规则
     *
     * @param wordId 词汇ID
     * @return 规则的视图类数组
     */
    List<RuleVo> getWordAssociatedRulesByWordId(Long wordId);

    /**
     * 获得与某个句型关联的所有规则
     *
     * @param sentenceId 句型ID
     * @return 规则的视图类数组
     */
    List<RuleVo> getSentenceAssociatedRulesBySentenceId(Long sentenceId);
}
