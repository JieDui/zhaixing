package com.example.catchstars.serviceImpl;

import com.example.catchstars.dao.CardandwebsiteMapper;
import com.example.catchstars.dao.WebsiteMapper;
import com.example.catchstars.model.Cardandwebsite;
import com.example.catchstars.model.Website;
import com.example.catchstars.resource.CardInfo;
import com.example.catchstars.resource.PageRequest;
import com.example.catchstars.resource.PageResult;
import com.example.catchstars.resource.WebSiteInfo;
import com.example.catchstars.service.WebSiteService;
import com.example.catchstars.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebSiteServiceImpl implements WebSiteService {

    @Autowired
    private CardandwebsiteMapper cardandwebsiteMapper;
    @Autowired
    private WebsiteMapper websiteMapper;

    public PageResult findPage(PageRequest pageRequest, int cardId) {
        return PageUtil.getPageResult(pageRequest, getPageInfo(pageRequest, cardId));
    }

    public boolean delAWebSiteFromCard(int cardId, int webSiteId) {
        Cardandwebsite cardandwebsite = cardandwebsiteMapper.selectByFilter(cardId, webSiteId);
        if (cardandwebsite == null) {
            return false;
        }
        cardandwebsiteMapper.deleteByPrimaryKey(cardandwebsite.getId());
        return true;
    }

    public boolean addAWebSiteToCard(int webSiteId, int cardId) {
        Cardandwebsite cardandwebsite = new Cardandwebsite();
        cardandwebsite.setCardId(cardId);
        cardandwebsite.setWebsite_id(webSiteId);
        int result = cardandwebsiteMapper.insertSelective(cardandwebsite);
        if (result == 0) {
            return false;
        }
        return true;
    }

    public boolean modifyWebSite(Website website) {
        int result = websiteMapper.updateByPrimaryKeySelective(website);
        if (result == 0) {
            return false;
        }
        return true;
    }

    private PageInfo<Website> getPageInfo(PageRequest pageRequest, int cardId) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Website> list = cardandwebsiteMapper.selectByCardId(cardId);
        return new PageInfo<Website>(list);
    }
}
