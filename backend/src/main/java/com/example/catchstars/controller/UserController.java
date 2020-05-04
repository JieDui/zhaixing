package com.example.catchstars.controller;

import com.example.catchstars.resource.LoginResource;
import com.example.catchstars.resource.UserInfo;
import com.example.catchstars.service.UserService;
import com.example.catchstars.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Api(tags = "用户接口")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    HttpSession session;
    private static String SESSION_KEY = "user";

    @ApiOperation(value = "失败", httpMethod = "GET")
    @GetMapping(value = "/fail")
    public String fail() {
        return "fail";
    }

    @ApiOperation(value = "返回用户信息", httpMethod = "GET")
    @GetMapping(value = "/starts/user/info")
    public Object UserInfo() {
        if (session.getAttribute(SESSION_KEY) == null) {
            return JsonResult.forbidden("please login first", null);
        }
        String name = (String) session.getAttribute(SESSION_KEY);
        return JsonResult.ok(userService.getUserInfo(name));
    }

    @ApiOperation(value = "登入", httpMethod = "POST")
    @PostMapping("/starts/user/login")
    public Object Login(@RequestBody LoginResource loginResource) {
        String nameInput = loginResource.getName();
        String passwordInput = loginResource.getPassword();
        if (userService.valiteUser(nameInput, passwordInput)) {
            session.setAttribute(SESSION_KEY, nameInput);
            return JsonResult.ok("");
        }
        return  JsonResult.unprocessableEntity("sign in error", null);
    }

    @ApiOperation(value = "登出", httpMethod = "POST")
    @PostMapping("/starts/user/logout")
    public Object sigout() {
        session.removeAttribute(SESSION_KEY);
        return JsonResult.ok("");
    }

    @ApiOperation(value = "注册", httpMethod = "POST")
    @PostMapping("/starts/user/register")
    public Object register(@RequestBody UserInfo userInfo) {
        if (userService.addUser(userInfo)) {
            return JsonResult.ok("register ok");
        }
        return JsonResult.unprocessableEntity("user name has conflict", null);
    }

}
