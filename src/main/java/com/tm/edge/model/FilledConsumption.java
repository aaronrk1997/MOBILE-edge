package com.tm.edge.model;

import java.util.Date;
import java.util.List;

import com.tm.edge.model.*;

public class FilledConsumption {
    private String id;
    private String userId;
    private String beerId;
    private Integer count;
    private Integer score;
    private String remark;
    private Date createdAt;
    private Beer beer;

    
    public FilledConsumption( Beer beer, Consumption consumption) {
        setId(consumption.getId());
        setUserId(consumption.getUserId());
        setBeerId(consumption.getBeerId());
        setCount(consumption.getCount());
        setScore(consumption.getScore());
        setRemark(consumption.getRemark());
        setCreatedAt(consumption.getCreatedAt());
        setBeer(beer);
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    
}
