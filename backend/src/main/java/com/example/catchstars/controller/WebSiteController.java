package com.example.catchstars.controller;

import com.example.catchstars.resource.PageRequest;
import com.example.catchstars.resource.UserInfo;
import com.example.catchstars.service.UserService;
import com.example.catchstars.serviceImpl.CardServiceImpl;
import com.example.catchstars.serviceImpl.UserServiceImpl;
import com.example.catchstars.serviceImpl.WebSiteServiceImpl;
import com.example.catchstars.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Api(tags = "网站部分接口")
@RestController
public class WebSiteController {

    @Autowired
    private WebSiteServiceImpl webSiteService;
    @Autowired
    private CardServiceImpl cardService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    HttpSession session;
    private static String SESSION_KEY = "user";

    @ApiOperation(value = "卡片网站分页展示", httpMethod = "POST")
    @PostMapping("/starts/websites")
    public Object getCardAllWebSite(@RequestBody PageRequest pageRequest, @RequestParam int cardId) {
        if (session.getAttribute(SESSION_KEY) == null) {
            return JsonResult.forbidden("please login first", null);
        }
        String name = (String) session.getAttribute(SESSION_KEY);
        UserInfo userInfo = userService.getUserInfo(name);
        if (cardService.hasPower(userInfo.getId(), cardId)) {
            return JsonResult.ok(webSiteService.findPage(pageRequest, cardId));
        } else {
            return JsonResult.forbidden("this card is not yours", null);
        }
    }
}
