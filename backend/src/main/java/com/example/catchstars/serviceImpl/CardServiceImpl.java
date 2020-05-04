package com.example.catchstars.serviceImpl;

import com.example.catchstars.dao.CardMapper;
import com.example.catchstars.model.Card;
import com.example.catchstars.resource.CardInfo;
import com.example.catchstars.resource.PageRequest;
import com.example.catchstars.resource.PageResult;
import com.example.catchstars.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl {

    @Autowired
    private CardMapper cardMapper;

    public int addACard(Card card) {
        int result = cardMapper.insertSelective(card);
        return result;
    }

    public boolean delACard(int userId, int cardId) {
        if (!hasPower(userId, cardId)) {
            return false;
        } else {
            cardMapper.deleteByPrimaryKey(cardId);
        }
        return true;
    }

    public PageResult findPage(PageRequest pageRequest, int userId, boolean outDate) {
        return PageUtil.getPageResult(pageRequest, getPageInfo(pageRequest, userId, outDate));
    }

    public boolean setCardOutDate(int userId, int cardId, boolean outDate) {
        if (!hasPower(userId, cardId)) {
            return false;
        }
        Card card = cardMapper.selectByPrimaryKey(cardId);
        if (card == null) {
            return false;
        }
        card.setOutofDate(outDate);
        cardMapper.updateByPrimaryKeySelective(card);
        return true;
    }

    private PageInfo<CardInfo> getPageInfo(PageRequest pageRequest, int userId, boolean outDate) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<CardInfo> list = cardMapper.selectByUserIdPage(userId, outDate);
        return new PageInfo<CardInfo>(list);
    }

    public boolean hasPower(int userId, int cardId) {
        Card card = cardMapper.selectByPrimaryKey(cardId);
        if (userId != card.getUserId()) {
            return false;
        }
        return true;
    }
}
