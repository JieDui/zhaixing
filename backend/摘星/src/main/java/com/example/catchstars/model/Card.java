package com.example.catchstars.model;

import java.util.List;

public class Card {
    private Integer id;

    private String title;

    private Integer userId;

    private Boolean outofDate;

    private List<Website> websites;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getOutofDate() {
        return outofDate;
    }

    public void setOutofDate(Boolean outofDate) {
        this.outofDate = outofDate;
    }

    public List<Website> getWebsites() {
        return websites;
    }

    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", userId=").append(userId);
        sb.append(", outofDate=").append(outofDate);
        sb.append("]");
        return sb.toString();
    }
}