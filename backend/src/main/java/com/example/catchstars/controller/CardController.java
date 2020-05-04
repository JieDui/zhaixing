package com.example.catchstars.controller;

import com.example.catchstars.model.Card;
import com.example.catchstars.resource.*;
import com.example.catchstars.service.CardService;
import com.example.catchstars.service.UserService;
import com.example.catchstars.serviceImpl.CardServiceImpl;
import com.example.catchstars.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Api(tags = "卡片接口")
@RestController
public class CardController {

    @Autowired
    private CardServiceImpl cardService;
    @Autowired
    private UserService userService;
    @Autowired
    HttpSession session;
    private static String SESSION_KEY = "user";

    @ApiOperation(value = "分页展示用户的卡片, 可指定卡片是否过时", httpMethod = "POST")
    @PostMapping(value = "/starts/cards/")
    public Object listUserCards(@RequestBody PageRequest pageRequest,
                                @RequestParam boolean outdate) {
        if (session.getAttribute(SESSION_KEY) == null) {
            return JsonResult.forbidden("please login first", null);
        }
        String name = (String) session.getAttribute(SESSION_KEY);
        UserInfo userInfo = userService.getUserInfo(name);
        return JsonResult.ok(cardService.findPage(pageRequest, userInfo.getId(), outdate));
    }

    @ApiOperation(value = "添加一个卡片", httpMethod = "POST")
    @PostMapping(value = "/starts/cards/add")
    public Object addACard(@RequestParam String title) {
        if (session.getAttribute(SESSION_KEY) == null) {
            return JsonResult.forbidden("please login first", null);
        }
        String name = (String) session.getAttribute(SESSION_KEY);
        UserInfo userInfo = userService.getUserInfo(name);
        Card card = new Card();
        card.setTitle(title);
        card.setUserId(userInfo.getId());
        card.setOutofDate(false);
        int result = cardService.addACard(card);
        if (result == 0) {
            return JsonResult.badRequest("bad request", null);
        }
        return JsonResult.ok("");
    }

    @ApiOperation(value = "设置卡片过时标志", httpMethod = "POST")
    @PostMapping(value = "/starts/cards/outdate")
    public Object setOutDate(@RequestBody OutDateRequest outDateRequest) {
        if (session.getAttribute(SESSION_KEY) == null) {
            return JsonResult.forbidden("please login first", null);
        }
        String name = (String) session.getAttribute(SESSION_KEY);
        UserInfo userInfo = userService.getUserInfo(name);
        if (cardService.setCardOutDate(userInfo.getId(),
                outDateRequest.getId(), outDateRequest.getOutofDate())) {
            return JsonResult.ok("");
        } else {
            return JsonResult.forbidden("this card is not yours", null);
        }
    }

    @DeleteMapping(value = "/starts/cards/del")
    public Object delOneCard(@RequestParam int cardId) {
        if (session.getAttribute(SESSION_KEY) == null) {
            return JsonResult.forbidden("please login first", null);
        }
        String name = (String) session.getAttribute(SESSION_KEY);
        UserInfo userInfo = userService.getUserInfo(name);
        if (cardService.delACard(userInfo.getId(), cardId)) {
            return JsonResult.ok("");
        } else {
            return JsonResult.forbidden("this card is not yours", null);
        }
    }

}
