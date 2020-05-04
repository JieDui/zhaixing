package com.example.catchstars.resource;

public class CardInfo {
    private Integer id;

    private String title;

    private Integer userId;

    private Boolean outofDate;

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


}
