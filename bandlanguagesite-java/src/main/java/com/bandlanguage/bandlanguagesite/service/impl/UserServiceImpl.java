package com.bandlanguage.bandlanguagesite.service.impl;

import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.cache.prefix.UserKey;
import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.mapper.UserMapper;
import com.bandlanguage.bandlanguagesite.model.entity.User;
import com.bandlanguage.bandlanguagesite.model.vo.LoginByUsernameVo;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.UserService;
import com.bandlanguage.bandlanguagesite.util.MD5Util;
import com.bandlanguage.bandlanguagesite.util.SaltUtil;
import com.bandlanguage.bandlanguagesite.util.UUIDUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * 用户业务逻辑的实现类
 *
 * @author xiaov
 * @since 2021-05-24 16:56
 */
@Service
public class UserServiceImpl implements UserService {

    public static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    private IGlobalCache redisService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User getUserByPhone(String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile",phone);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User getUserByEmail(String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",email);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean register(HttpServletResponse response, User user) {
        if(user == null)
            throw new GlobalException(ResultCode.SERVER_ERROR);

        // 检查用户名是否已存在
        if(user.getUsername() != null){
            User dbUser = getUserByUsername(user.getUsername());
            if(dbUser != null)
                throw new GlobalException(ResultCode.REGISTER_USERNAME_EXIST);
        }

        // 检查用户手机号是否已存在
        if(user.getMobile() != null){
            User dbUser = getUserByPhone(user.getMobile());
            if(dbUser != null)
                throw new GlobalException(ResultCode.REGISTER_MOBILE_EXISTZ);
        }

        // 检查用户邮箱是否已存在
        if(user.getEmail() != null){
            User dbUser = getUserByEmail(user.getEmail());
            if(dbUser != null)
                throw new GlobalException(ResultCode.REGISTER_EMAIL_EXIST);
        }

        String salt = SaltUtil.getSalt(12);
        user.setSalt(salt);
        user.setPassword(MD5Util.formPassToDBPass(user.getPassword(), salt));
        user.setRegisterDate(new Date());
        int count = userMapper.insert(user);
        return count > 0;
    }

    @Override
    public User loginByUsername(HttpServletResponse response, LoginByUsernameVo loginVo) {
        if(loginVo == null)
            throw new GlobalException(ResultCode.SERVER_ERROR);

        // 验证用户是否注册
        User user = getUserByUsername(loginVo.getUsername());
        if(user == null)
            throw new GlobalException(ResultCode.USERNAME_NOT_EXIST);

        if(user.getUserId() == 1)
            throw new GlobalException(ResultCode.VISITOR_NEED_NOT_LOGIN);
        // 验证表单密码加密之后是否与数据库密码吻合
        String calcPass = MD5Util.formPassToDBPass(loginVo.getPassword(), user.getSalt());
        if(!calcPass.equals(user.getPassword()))
            throw new GlobalException(ResultCode.PASSWORD_ERROR);
        // 将用户登录次数＋1
        user.setLoginCount(user.getLoginCount() + 1);
        userMapper.updateById(user);

        //生成cookie 将token返回浏览器 分布式session
        String token = UUIDUtil.uuid();
        addCookie(response,token,user);
        return user;
    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        // 分布式session存进redis
        redisService.set(UserKey.token.getPrefix()+token,user);

        // 生成cookie，设置有效期
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public boolean updatePassword(String token, long userId, String formPass) {
        return false;
    }

    @Override
    public User getByToken(HttpServletResponse response, String token) {
        return null;
    }

    @Override
    public String createToken(HttpServletResponse response, LoginByUsernameVo login) {
        return null;
    }
}
