package com.bandlanguage.bandlanguagesite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.exception.GlobalException;
import com.bandlanguage.bandlanguagesite.exception.UserLoginException;
import com.bandlanguage.bandlanguagesite.mapper.UserMapper;
import com.bandlanguage.bandlanguagesite.model.entity.User;
import com.bandlanguage.bandlanguagesite.model.vo.LoginByUsernameVo;
import com.bandlanguage.bandlanguagesite.result.ResultCode;
import com.bandlanguage.bandlanguagesite.service.UserService;
import com.bandlanguage.bandlanguagesite.util.HttpUtil;
import com.bandlanguage.bandlanguagesite.util.MD5Util;
import com.bandlanguage.bandlanguagesite.util.SaltUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 用户业务逻辑的实现类
 *
 * @author xiaov
 * @since 2021-05-24 16:56
 */
@Service
public class UserServiceImpl implements UserService {

    public static final String COOKIE_NAME_TOKEN = "access_token";

    @Autowired
    private IGlobalCache redisService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject getUserById(Long userId) {

//        return userMapper.selectById(userId);
        return null;
    }

//    @Override
//    public User getUserByUsername(String username) {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username", username);
//        return userMapper.selectOne(queryWrapper);
//    }

//    @Override
//    public User getUserByPhone(String phone) {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("mobile", phone);
//        return userMapper.selectOne(queryWrapper);
//    }

//    @Override
//    public User getUserByEmail(String email) {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("email", email);
//        return userMapper.selectOne(queryWrapper);
//    }

//    @Override
//    public boolean register(HttpServletResponse response, User user) {
//        if (user == null)
//            throw new GlobalException(ResultCode.SERVER_ERROR);
//
//        // 检查用户名是否已存在
//        if (user.getUsername() != null) {
//            User dbUser = getUserByUsername(user.getUsername());
//            if (dbUser != null)
//                throw new GlobalException(ResultCode.REGISTER_USERNAME_EXIST);
//        }
//
//        // 检查用户手机号是否已存在
//        if (user.getMobile() != null) {
//            User dbUser = getUserByPhone(user.getMobile());
//            if (dbUser != null)
//                throw new GlobalException(ResultCode.REGISTER_MOBILE_EXIST);
//        }
//
//        // 检查用户邮箱是否已存在
//        if (user.getEmail() != null) {
//            User dbUser = getUserByEmail(user.getEmail());
//            if (dbUser != null)
//                throw new GlobalException(ResultCode.REGISTER_EMAIL_EXIST);
//        }
//
//        String salt = SaltUtil.getSalt(12);
//        user.setSalt(salt);
//        user.setPassword(MD5Util.formPassToDBPass(user.getPassword(), salt));
//        user.setRegisterDate(new Date());
//        int count = userMapper.insert(user);
//        return count > 0;
//    }

    @Override
    public JSONObject loginByUsername(HttpServletResponse response, LoginByUsernameVo loginVo) throws Exception {
        if (loginVo == null)
            throw new GlobalException(ResultCode.SERVER_ERROR);

//        // 验证用户是否注册
//        User user = getUserByUsername(loginVo.getUsername());
//        if (user == null)
//            throw new GlobalException(ResultCode.USERNAME_NOT_EXIST);

//        if (user.getUserId() == 1)
//            throw new GlobalException(ResultCode.VISITOR_NEED_NOT_LOGIN);
        // 验证表单密码加密之后是否与数据库密码吻合
//        String calcPass = MD5Util.formPassToDBPass(loginVo.getPassword(), user.getSalt());
//        if (!calcPass.equals(user.getPassword()))
//            throw new GlobalException(ResultCode.PASSWORD_ERROR);
//        // 将用户登录次数＋1
//        user.setLoginCount(user.getLoginCount() + 1);
//        userMapper.updateById(user);

//        //生成cookie 将token返回浏览器 分布式session
//        String token = UUIDUtil.uuid();
//        addCookie(response, token, user);
//        return user;

        Map<String, String> loginMap = new HashMap<>();

        loginMap.put("name", loginVo.getUsername());
        loginMap.put("password", loginVo.getPassword());
        loginMap.put("aid", "21419389378723787447");
        loginMap.put("format", "json");

        HttpResponse resp = HttpUtil.doPost("https://www.wetoband.com",
                "/core/core/v4/authc/user", new HashMap<>(), loginMap, (Map<String, String>) null);
        JSONObject resObj = HttpUtil.parseJson(resp);
        JSONObject user = null;
        if (resObj.containsKey("rows")) {
            user = resObj.getJSONArray("rows").getJSONObject(0);
        }
        String accessToken = HttpUtil.getValueFromHeaders(resp, "Set-Cookie", "access_token");
        if (user == null || StringUtils.isEmpty(accessToken)) {
            System.out.println("resObj = " + resObj);
            if (resObj.containsKey("result") && resObj.containsKey("msg")
                    && "false".equals(resObj.getString("result")) && "不存在的用户".equals(resObj.getString("msg")))
                throw new GlobalException(ResultCode.USERNAME_NOT_EXIST);
            if (resObj.containsKey("error") && resObj.getJSONObject("error").containsKey("message")
                    && "密码错误".equals(resObj.getJSONObject("error").getString("message")))
                throw new GlobalException(ResultCode.PASSWORD_ERROR);
            throw new GlobalException(ResultCode.LOGIN_FAIL);
        }

        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("accessToken", accessToken);
        addCookie(response,"access_token",accessToken,0);
        return user;
    }

//    private void addCookie(HttpServletResponse response, String token, User user) {
//        // 分布式session存进redis
//        redisService.set(UserKey.token.getPrefix() + token, user);
//
//        // 生成cookie，设置有效期
//        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
//        cookie.setMaxAge(UserKey.token.expireSeconds());
//        cookie.setPath("/");
//        response.addCookie(cookie);
//    }

    private void addCookie(HttpServletResponse response, String cookieName, String cookieValue, int maxAge) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setDomain(".wetoband.com");
        cookie.setPath("/");
        cookie.setHttpOnly(false);
        if (maxAge > 0)
            cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    @Override
    public JSONObject getUserByToken() throws IOException {
        // 1. 获取accessToken
        String accessToken = getAccessToken();
        if(StringUtils.isEmpty(accessToken))
            throw new UserLoginException();
//        System.out.println("accessToken = " + accessToken);

        // 2. 根据accessToken请求核心接口获得用户信息
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("access_token", accessToken);
        queryMap.put("aid", "21419389378723787447");
        queryMap.put("format", "json");

        HttpResponse resp = HttpUtil.doGet("https://www.wetoband.com",
                "/core/core/v4/user/me", new HashMap<>(), queryMap);
        JSONObject resObj = HttpUtil.parseJson(resp);
        JSONObject user = null;
        if (resObj.containsKey("rows")) {
            user = resObj.getJSONArray("rows").getJSONObject(0);
        }
//        System.out.println("user = " + user);
        return user;
    }

    @Override
    public Boolean logout() throws Exception {
        // 1. 获取accessToken
        String accessToken = getAccessToken();
        if(StringUtils.isEmpty(accessToken))
            throw new UserLoginException();

        // 2. 根据accessToken请求核心接口完成用户登出
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("access_token", accessToken);
        queryMap.put("aid", "21419389378723787447");
        queryMap.put("format", "json");

        HttpResponse resp = HttpUtil.doDelete("https://www.wetoband.com",
                "/core/core/v4/authc/user", new HashMap<>(), queryMap);
        JSONObject resObj = HttpUtil.parseJson(resp);
        System.out.println("resObj = " + resObj);

        // 3. 做游客登陆
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = Objects.requireNonNull(servletRequestAttributes).getResponse();
        LoginByUsernameVo loginVo = LoginByUsernameVo.builder().username("wtbpublic").password("fypublic").build();
        loginByUsername(response,loginVo);
        return true;

    }

    @Override
    public String getAccessToken() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        HttpSession session = request.getSession();
        String accessToken = session.getAttribute("accessToken").toString();
        if(StringUtils.isEmpty(accessToken))
            return null;
        return accessToken;
    }
}
