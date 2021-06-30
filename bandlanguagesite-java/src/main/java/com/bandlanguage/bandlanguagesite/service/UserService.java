package com.bandlanguage.bandlanguagesite.service;

import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.model.entity.User;
import com.bandlanguage.bandlanguagesite.model.vo.LoginByUsernameVo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    JSONObject getUserById(Long userId);

    /**
     * 根据用户的用户名查询用户
     *
     * @param username 用户的用户名
     * @return 查询的用户JSON对象
     */
//    Object getUserByUsername(String username);    //(对接帮区，该方法无)

    /**
     * 根据用户的电话号码查询用户
     *
     * @param phone 用户的电话号码
     * @return 查询的用户实体类
     */
//    User getUserByPhone(String phone);    //(对接帮区，该方法无)

    /**
     * 根据用户的邮箱查询用户
     *
     * @param email 用户的邮箱号
     * @return 查询的用户实体类
     */
//    User getUserByEmail(String email);    //(对接帮区，该方法无)

    /**
     * 注册用户
     *
     * @param response HttpServletResponse
     * @param user     用户实体类
     * @return 是否成功
     */
//    boolean register(HttpServletResponse response, User user);    //(对接帮区，直接使用帮区注册工具)

    /**
     * 根据用户名登陆
     *
     * @param response HttpServletResponse
     * @param loginVo  用户名登陆的输入类
     * @return 登陆是否成功
     */
    JSONObject loginByUsername(HttpServletResponse response, LoginByUsernameVo loginVo) throws Exception;

    /**
     * 修改密码
     *
     * @param token    用户token
     * @param userId   用户ID
     * @param formPass 输入的密码
     * @return 修改密码是否成功
     */
//    boolean updatePassword(String token, long userId, String formPass);   //(对接帮区，该方法无)


    /**
     * 根据session里面的accessToken来请求用户
     *
     * @return 用户的JSON格式对象
     */
    JSONObject getUserByToken() throws IOException;

    /**
     * 用户登出
     * @return 用户登出是否成功
     */
    Boolean logout() throws Exception;

    /**
     * 获得session里面的accessToken
     * @return session里面的accessToken
     */
    String getAccessToken();
}
