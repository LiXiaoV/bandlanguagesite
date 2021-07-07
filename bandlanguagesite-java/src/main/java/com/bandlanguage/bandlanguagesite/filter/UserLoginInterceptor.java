package com.bandlanguage.bandlanguagesite.filter;

import com.bandlanguage.bandlanguagesite.model.vo.LoginByUsernameVo;
import com.bandlanguage.bandlanguagesite.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaov
 * @since 2021-06-24 17:17
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    /**
     * true 表示继续流程，false表示中断
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param handler Object
     * @return boolean
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accessToken = "";
        // 1. 获取cookie里面的accessToken
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if("access_token".equals(cookie.getName()))
                    accessToken = cookie.getValue();
            }
        }
        // 2. 如果accessToken不存在或已失效，则执行游客登陆并报告异常
        if(StringUtils.isEmpty(accessToken)){
            LoginByUsernameVo loginVo = LoginByUsernameVo.builder().username("wtbpublic").password("fypublic").build();
            userService.loginByUsername(response,loginVo);
        }
        // 3. 如果accessToken存在，则放行
        return true;
    }

}
