package com.example.RankingServiceDemo.DataClasses;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RankingRequest{
    @NotEmpty(message = "hotelids should not be null")
    private List<String> hotelids;
    @NotEmpty(message = "city id should not be null")
    private String cityid;

    public  RankingRequest(){}
    public RankingRequest(List<String> hotelids, String cityid) {
        this.hotelids = hotelids;
        this.cityid = cityid;
    }

    public List<String> getHotelids() {
        return hotelids;
    }

    public void setHotelids(List<String> hotelids) {
        this.hotelids = hotelids;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
}