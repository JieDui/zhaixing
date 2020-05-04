package com.example.catchstars.model;

public class Cardandwebsite {
    private Integer id;

    private Integer cardId;


    private Integer website_id;

    private Website website;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getWebsite_id() {
        return website_id;
    }

    public void setWebsite_id(Integer website_id) {
        this.website_id = website_id;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cardId=").append(cardId);
        sb.append(", websiteId=").append(website);
        sb.append("]");
        return sb.toString();
    }
}