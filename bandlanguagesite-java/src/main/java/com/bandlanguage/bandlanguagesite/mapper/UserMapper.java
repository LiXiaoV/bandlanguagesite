package com.bandlanguage.bandlanguagesite.mapper;

import com.bandlanguage.bandlanguagesite.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户的模型类
 *
 * @author xiaov
 * @since 2021-05-24 16:52
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户的电话号码查询用户
     *
     * @param phone 用户的电话号码
     * @return 查询的用户实体类
     */
    User getUserByPhone(Long phone);

    /**
     * 根据用户的邮箱查询用户
     * @param email 用户的邮箱号
     * @return 查询的用户实体类
     */
    User getUserByEmail(Long email);
}
