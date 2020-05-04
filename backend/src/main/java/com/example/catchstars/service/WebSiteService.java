package com.example.catchstars.service;

import com.example.catchstars.model.Website;
import com.example.catchstars.resource.PageRequest;
import com.example.catchstars.resource.PageResult;

import java.util.List;

public interface WebSiteService {

    public PageResult findPage(PageRequest pageRequest, int cardId);

    public boolean delAWebSiteFromCard(int webSiteId, int cardId);

    public boolean addAWebSiteToCard(int webSiteId, int cardId);

    public boolean modifyWebSite(Website website);
}
