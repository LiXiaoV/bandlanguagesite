package com.bandlanguage.bandlanguagesite.service;

import com.bandlanguage.bandlanguagesite.model.entity.User;
import com.bandlanguage.bandlanguagesite.model.vo.LoginByUsernameVo;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaov
 * @since 2021-05-24 16:54
 */
public interface UserService {

    /**
     * 根据用户ID查询用户
     *
     * @param userId 用户ID
     * @return 查询的用户实体类
     */
    User getUserById(Long userId);

    /**
     * 根据用户的用户名查询用户
     *
     * @param phone 用户的用户名
     * @return 查询的用户实体类
     */
    User getUserByUsername(String username);

    /**
     * 根据用户的电话号码查询用户
     *
     * @param phone 用户的电话号码
     * @return 查询的用户实体类
     */
    User getUserByPhone(String phone);

    /**
     * 根据用户的邮箱查询用户
     * @param email 用户的邮箱号
     * @return 查询的用户实体类
     */
    User getUserByEmail(String email);

    /**
     * 注册用户
     * @param response HttpServletResponse
     * @param user 用户实体类
     * @return 是否成功
     */
    boolean register(HttpServletResponse response,User user);

    /**
     * 根据用户名登陆
     * @param response HttpServletResponse
     * @param loginVo 用户名登陆的输入类
     * @return 登陆是否成功
     */
    User loginByUsername(HttpServletResponse response, LoginByUsernameVo loginVo);

    /**
     * 修改密码
     * @param token 用户token
     * @param userId 用户ID
     * @param formPass 输入的密码
     * @return 修改密码是否成功
     */
    boolean updatePassword(String token, long userId, String formPass);



    User getByToken(HttpServletResponse response,String token);

    String createToken(HttpServletResponse response,LoginByUsernameVo login);
}
