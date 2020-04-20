package com.example.RankingServiceDemo.DataClasses;

import io.searchbox.annotations.JestId;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("UserData")
public class UserData {

    @JestId
    @Id
    private String userid;
    private double user_abp;

    public UserData(String userid, double user_abp) {
        this.userid = userid;
        this.user_abp = user_abp;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public double getUser_abp() {
        return user_abp;
    }

    public void setUser_abp(double user_abp) {
        this.user_abp = user_abp;
    }
}
