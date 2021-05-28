package com.bandlanguage.bandlanguagesite.mapper;


import com.bandlanguage.bandlanguagesite.model.entity.WordUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 词汇-用户的模型类
 *
 * @author xiaov
 * @since 2021-05-28 10:36
 */
@Mapper
public interface WordUserMapper extends BaseMapper<WordUser> {
}
