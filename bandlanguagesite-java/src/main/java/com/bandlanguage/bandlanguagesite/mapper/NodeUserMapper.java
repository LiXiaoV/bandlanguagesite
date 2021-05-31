package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.NodeUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 节点-用户的模型类
 *
 * @author xiaov
 * @since 2021-05-31 11:43
 */
@Mapper
public interface NodeUserMapper extends BaseMapper<NodeUser> {
}
