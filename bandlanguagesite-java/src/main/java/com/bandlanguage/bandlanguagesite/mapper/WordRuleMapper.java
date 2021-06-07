package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.WordRule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 词汇-规则的模型类
 *
 * @author xiaov
 * @since 2021-06-07 20:51
 */
@Mapper
public interface WordRuleMapper extends BaseMapper<WordRule> {
}
