package com.example.RankingServiceDemo.DataClasses;

import java.util.List;

public class RankingResponse {

    private List<String> hotelids;

    public RankingResponse(List<String> hotelids) {
        this.hotelids = hotelids;
    }

    public List<String> getHotelids() {
        return hotelids;
    }

    public void setHotelids(List<String> hotelids) {
        this.hotelids = hotelids;
    }
}
