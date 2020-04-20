package com.example.RankingServiceDemo.DataClasses;

import io.searchbox.annotations.JestId;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Hotel")
public class Dataset {

    @Id
    @JestId
    private String hotelid;
    private String userid;
    private double fprice;
    private double hotelType;
    private double user_abp;
    private double discount_per;
    private double hotel_btod;
    private double hotel_user_br;
    private double hotel_user_ctr;
    private double hotel_user_btod;
    private double avg_user_rr;
    private boolean is_weekend_checkin;
    private double recom_score;
    private double ratingMean;
    private double ratingCount;
    private boolean is_city_search;
    private boolean is_locality_search;
    private double hotel_placeid_ctr;
    private double hotel_placeid_br;
    private double hotel_placeid_dtob;
    private double user_cat_ctr;
    private double user_cat_br;
    private double user_cat_dtob;

    private double distance;

    public Dataset(){
    }
    public Dataset(String hotelid, String userid, double fprice, double hotelType, double user_abp, double discount_per, double hotel_btod, double hotel_user_br, double hotel_user_ctr, double hotel_user_btod, double avg_user_rr, boolean is_weekend_checkin, double recom_score, double ratingMean, double ratingCount, boolean is_city_search, boolean is_locality_search, double hotel_placeid_ctr, double hotel_placeid_br, double hotel_placeid_dtob, double user_cat_ctr, double user_cat_br, double user_cat_dtob, double distance) {
        this.hotelid = hotelid;
        this.userid = userid;
        this.fprice = fprice;
        this.hotelType = hotelType;
        this.user_abp = user_abp;
        this.discount_per = discount_per;
        this.hotel_btod = hotel_btod;
        this.hotel_user_br = hotel_user_br;
        this.hotel_user_ctr = hotel_user_ctr;
        this.hotel_user_btod = hotel_user_btod;
        this.avg_user_rr = avg_user_rr;
        this.is_weekend_checkin = is_weekend_checkin;
        this.recom_score = recom_score;
        this.ratingMean = ratingMean;
        this.ratingCount = ratingCount;
        this.hotel_placeid_ctr = hotel_placeid_ctr;
        this.hotel_placeid_br = hotel_placeid_br;
        this.hotel_placeid_dtob = hotel_placeid_dtob;
        this.is_city_search = is_city_search;
        this.is_locality_search = is_locality_search;
        this.user_cat_ctr = user_cat_ctr;
        this.user_cat_br = user_cat_br;
        this.user_cat_dtob = user_cat_dtob;
        this.distance = distance;
    }



    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public double getFprice() {
        return fprice;
    }

    public void setFprice(double fprice) {
        this.fprice = fprice;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getHotel_placeid_ctr() {
        return hotel_placeid_ctr;
    }

    public void setHotel_placeid_ctr(double hotel_placeid_ctr) {
        this.hotel_placeid_ctr = hotel_placeid_ctr;
    }

    public double getHotel_placeid_br() {
        return hotel_placeid_br;
    }

    public void setHotel_placeid_br(double hotel_placeid_br) {
        this.hotel_placeid_br = hotel_placeid_br;
    }

    public double getHotel_placeid_dtob() {
        return hotel_placeid_dtob;
    }

    public void setHotel_placeid_dtob(double hotel_placeid_dtob) {
        this.hotel_placeid_dtob = hotel_placeid_dtob;
    }

    public double getHotel_user_br() {
        return hotel_user_br;
    }

    public void setHotel_user_br(double hotel_user_br) {
        this.hotel_user_br = hotel_user_br;
    }

    public double getHotel_user_ctr() {
        return hotel_user_ctr;
    }

    public void setHotel_user_ctr(double hotel_user_ctr) {
        this.hotel_user_ctr = hotel_user_ctr;
    }

    public double getHotel_user_btod() {
        return hotel_user_btod;
    }

    public void setHotel_user_btod(double hotel_user_btod) {
        this.hotel_user_btod = hotel_user_btod;
    }


    public double getHotelType() {
        return hotelType;
    }

    public void setHotelType(double hotelType) {
        this.hotelType = hotelType;
    }

    public double getUser_abp() {
        return user_abp;
    }

    public void setUser_abp(double user_abp) {
        this.user_abp = user_abp;
    }

    public double getDiscountPer() {
        return discount_per;
    }

    public void setDiscountPer(double discount_per) {
        this.discount_per = discount_per;
    }

    public double getHotel_btod() {
        return hotel_btod;
    }

    public void setHotel_btod(double hotel_btod) {
        this.hotel_btod = hotel_btod;
    }

    public double getAvg_user_rr() {
        return avg_user_rr;
    }

    public void setAvg_user_rr(double avg_user_rr) {
        this.avg_user_rr = avg_user_rr;
    }

    public double getRecom_score() {
        return recom_score;
    }

    public void setRecom_score(double recom_score) {
        this.recom_score = recom_score;
    }

    public double getRatingMean() {
        return ratingMean;
    }

    public void setRatingMean(double ratingMean) {
        this.ratingMean = ratingMean;
    }

    public double getRatingcount() {
        return ratingCount;
    }

    public void setRatingcount(double ratingCount) {
        this.ratingCount = ratingCount;
    }

    public double getUser_cat_ctr() {
        return user_cat_ctr;
    }

    public void setUser_cat_ctr(double user_cat_ctr) {
        this.user_cat_ctr = user_cat_ctr;
    }

    public double getUser_cat_br() {
        return user_cat_br;
    }

    public void setUser_cat_br(double user_cat_br) {
        this.user_cat_br = user_cat_br;
    }

    public double getUser_cat_dtob() {
        return user_cat_dtob;
    }

    public void setUser_cat_dtob(double user_cat_dtob) {
        this.user_cat_dtob = user_cat_dtob;
    }

    public boolean isIs_city_search() {
        return is_city_search;
    }

    public void setIs_city_search(boolean is_city_search) {
        this.is_city_search = is_city_search;
    }

    public boolean isIs_locality_search() {
        return is_locality_search;
    }

    public void setIs_locality_search(boolean is_locality_search) {
        this.is_locality_search = is_locality_search;
    }

    public boolean isIs_weekend_checkin() {
        return is_weekend_checkin;
    }

    public void setIs_weekend_checkin(boolean is_weekend_checkin) {
        this.is_weekend_checkin = is_weekend_checkin;
    }


}
