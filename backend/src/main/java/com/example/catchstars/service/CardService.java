package com.example.catchstars.service;
import com.example.catchstars.resource.PageRequest;
import com.example.catchstars.resource.PageResult;

public interface CardService {

    public int addACard(int userId, int cardId);

    public boolean delACard(int userId, int cardId);

    public PageResult findPage(PageRequest pageRequest, int userId);

    public boolean setCardOutDate(int userId, int cardId);
}
