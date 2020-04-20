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
    private Date chechin;
    private Date checkout;
    private boolean is_weekend_checkin;
    private Date searchTime;






    public  RankingRequest(){}

    public RankingRequest(@NotEmpty(message = "hotelids should not be null") List<String> hotelids, @NotEmpty(message = "city id should not be null") String cityid, boolean isCitySearch, boolean nearbysearch, Date chechin, Date checkout, boolean is_weekend_checkin, Date searchTime) {
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

    public Date getChechin() {
        return chechin;
    }

    public void setChechin(Date chechin) {
        this.chechin = chechin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    public boolean isIs_weekend_checkin() {
        return is_weekend_checkin;
    }

    public void setIs_weekend_checkin(boolean is_weekend_checkin) {
        this.is_weekend_checkin = is_weekend_checkin;
    }
}