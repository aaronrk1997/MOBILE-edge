package com.tm.edge.model;

import java.util.Date;

public class Consumption{
    private String id;
    private Integer userId;
    private String beerId;
    private Integer count;
    private Integer score;
    private String remark;
    private Date createdAt;

    public Consumption() {
    }

    public Consumption(Integer userId, String beerId, Integer count, Integer score, String remark) {
        setUserId(userId);
        setBeerId(beerId);
        setCount(count);
        setScore(score);
        setRemark(remark);
        setCreatedAt(new Date());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBeerId() {
        return beerId;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
