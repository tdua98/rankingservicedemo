package com.example.RankingServiceDemo.DataClasses;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

public class RankingRequest{
    @NotEmpty(message = "hotelids should not be null")
    private List<String> hotelids;
    @NotEmpty(message = "city id should not be null")
    private String cityid;
    private boolean  isCitySearch;
    private boolean nearbysearch;
    private String chechin;
    private String checkout;
    private boolean is_weekend_checkin;
    private String searchTime;






    public  RankingRequest(){}

    public RankingRequest(@NotEmpty(message = "hotelids should not be null") List<String> hotelids, @NotEmpty(message = "city id should not be null") String cityid, boolean isCitySearch, boolean nearbysearch, String chechin,String checkout, boolean is_weekend_checkin, String searchTime) {
        this.hotelids = hotelids;
        this.cityid = cityid;
        this.isCitySearch = isCitySearch;
        this.nearbysearch = nearbysearch;
        this.chechin = chechin;
        this.checkout = checkout;
        this.is_weekend_checkin = is_weekend_checkin;
        this.searchTime = searchTime;
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

    public boolean isCitySearch() {
        return isCitySearch;
    }

    public void setCitySearch(boolean citySearch) {
        isCitySearch = citySearch;
    }

    public boolean isNearbysearch() {
        return nearbysearch;
    }

    public void setNearbysearch(boolean nearbysearch) {
        this.nearbysearch = nearbysearch;
    }

    public String getChechin() {
        return chechin;
    }

    public void setChechin(String chechin) {
        this.chechin = chechin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(String searchTime) {
        this.searchTime = searchTime;
    }

    public boolean isIs_weekend_checkin() {
        return is_weekend_checkin;
    }

    public void setIs_weekend_checkin(boolean is_weekend_checkin) {
        this.is_weekend_checkin = is_weekend_checkin;
    }
}