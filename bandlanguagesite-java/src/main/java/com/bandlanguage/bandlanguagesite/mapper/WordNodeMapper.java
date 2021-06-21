package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.WordNode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 词汇-节点的模型类
 *
 * @author xiaov
 * @since 2021-06-07 20:53
 */
@Mapper
public interface WordNodeMapper extends BaseMapper<WordNode> {
}
