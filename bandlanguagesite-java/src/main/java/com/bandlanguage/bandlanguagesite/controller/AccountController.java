package com.bandlanguage.bandlanguagesite.controller;

import com.bandlanguage.bandlanguagesite.model.entity.User;
import com.bandlanguage.bandlanguagesite.model.vo.LoginByEmailVo;
import com.bandlanguage.bandlanguagesite.model.vo.LoginByPhoneVo;
import com.bandlanguage.bandlanguagesite.model.vo.LoginByUsernameVo;
import com.bandlanguage.bandlanguagesite.result.Result;
import com.bandlanguage.bandlanguagesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaov
 * @since 2021-05-24 17:01
 */
@Controller
@RestController
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/doLoginByUsername", method = RequestMethod.POST)
    public Result loginByUsername(HttpServletResponse response, @RequestBody LoginByUsernameVo loginByUsernameVo) {
        User user = userService.loginByUsername(response, loginByUsernameVo);
        if (user != null) {
            return Result.success(user);
        }
        return Result.fail(500, "登陆失败");
    }

    @RequestMapping(value = "/doLoginByEmail", method = RequestMethod.POST)
    public Result loginByEmail(@RequestBody LoginByEmailVo loginByEmailVo) {
        return Result.success();
    }

    @RequestMapping(value = "/doLoginByPhone", method = RequestMethod.POST)
    public Result loginByPhone(@RequestBody LoginByPhoneVo loginByPhoneVo) {
        return Result.success();
    }

    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public Result register(HttpServletResponse response, @RequestBody User user) {
        boolean res = userService.register(response, user);
        if (res)
            return Result.success("注册用户成功");
        return Result.fail(500, "注册用户失败");
    }
}
