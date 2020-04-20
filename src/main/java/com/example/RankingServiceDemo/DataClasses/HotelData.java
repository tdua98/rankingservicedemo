package com.example.RankingServiceDemo.DataClasses;


import io.searchbox.annotations.JestId;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("HotelData")
public class HotelData {


    @JestId
    @Id
    private String hotelid;
    private double fprice;
    private double hotelslasherprice;
    private double distance;
    private  boolean bookingFlag;
    private boolean detailsFlag;
    private double hotelType;
    private double rating;
    private double rcount;
    private double raw_recommended_hotel_wc;
    private double impressioncount;
    private double detailcount;
    private double bookingcount;
    private double userimpressioncount;
    private double userdetailcount;
    private double userbookingcount;
    private double avg_user_rr;
    private double hotel_placeid_ctr;
    private double hotel_placeid_br;
    private double hotel_placeid_dtob;
    private double user_cat_ctr;
    private double user_cat_br;
    private double user_cat_dtob;

//    private double realisedBooking;
//    private double displayCategory;
//    private double place_popularity_score;
//    private double list_count;
//    private double detail_count;
//    private double booking_event_count;
//    private double totolBookings_forcheckin;
//    private double discount_per;
//    private double hotel_br;
//    private double hotel_ctr;
//    private double hotel_btod;
//    private double hotel_user_br;
//    private double hotel_user_ctr;
//    private double hotel_user_btod;
//    private double avg_hotel_rr;
//    private double avg_hotel_br;
//    private double avg_hotel_ctr;
//    private double avg_hotel_btod;
//    private double avg_user_rr;
//    private double abp_price_diff;
//    private double vicinity;
//
//

//        hotel_br = impressioncount==0?0:bookingcount/impressioncount;
//        hotel_ctr = impressioncount==0?0:detailcount/impressioncount;
//        hotel_btod =
//        avg_hotel_rr = totolBookings_forcheckin == 0 ? 0: realisedBookings/totolBookings_forcheckin;
//        avg_hotel_br = list_count==0?0:booking_event_count/list_count;
//        avg_hotel_ctr = list_count==0?0:detail_count/list_count;
//        avg_hotel_btod = detail_count==0?0:booking_event_count/detail_count;
//        avg_user_rr = total_user_bookings == 0 ? 0 : user_realized_booking/total_user_bookings;
//
//  F.when(F.datediff('checkout','checkin')>0,F.datediff('checkout','checkin')).otherwise(0).alias('stayLength'),
//  F.when(F.dayofweek('checkin').isin([6,7,1]),1).otherwise(0).alias('is_weekend_checkin'),
//  (F.dayofweek('checkin')).alias('day_of_week_checkin'),
//  F.when(F.dayofweek('searchdate').isin([6,7,1]),1).otherwise(0).alias('is_weekend_searchDate'),
//  F.dayofweek('searchdate').alias('day_of_week_searchDate'),
//  F.when(F.datediff('searchdate','checkin')>0,F.datediff('searchdate','checkin')).otherwise(0).alias('advPurchaseWindow'),
//


    public HotelData() {
    }

    public HotelData(String hotelid, double fprice, double hotelslasherprice, double distance, boolean bookingFlag, boolean detailsFlag, double hotelType, double rating, double rcount, double raw_recommended_hotel_wc, double impressioncount, double detailcount, double bookingcount, double userimpressioncount, double userdetailcount, double userbookingcount, double avg_user_rr, double hotel_placeid_ctr, double hotel_placeid_br, double hotel_placeid_dtob, double user_cat_ctr, double user_cat_br, double user_cat_dtob) {
        this.hotelid = hotelid;
        this.fprice = fprice;
        this.hotelslasherprice = hotelslasherprice;
        this.distance = distance;
        this.bookingFlag = bookingFlag;
        this.detailsFlag = detailsFlag;
        this.hotelType = hotelType;
        this.rating = rating;
        this.rcount = rcount;
        this.raw_recommended_hotel_wc = raw_recommended_hotel_wc;
        this.impressioncount = impressioncount;
        this.detailcount = detailcount;
        this.bookingcount = bookingcount;
        this.userimpressioncount = userimpressioncount;
        this.userdetailcount = userdetailcount;
        this.userbookingcount = userbookingcount;
        this.avg_user_rr = avg_user_rr;

        this.hotel_placeid_ctr = hotel_placeid_ctr;
        this.hotel_placeid_br = hotel_placeid_br;
        this.hotel_placeid_dtob = hotel_placeid_dtob;
        this.user_cat_ctr = user_cat_ctr;
        this.user_cat_br = user_cat_br;
        this.user_cat_dtob = user_cat_dtob;
    }


    public double getAvg_user_rr() {
        return avg_user_rr;
    }

    public void setAvg_user_rr(double avg_user_rr) {
        this.avg_user_rr = avg_user_rr;
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


    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }


    public double getFprice() {
        return fprice;
    }

    public void setFprice(double fprice) {
        this.fprice = fprice;
    }

    public double getHotelslasherprice() {
        return hotelslasherprice;
    }

    public void setHotelslasherprice(double hotelslasherprice) {
        this.hotelslasherprice = hotelslasherprice;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }



    public boolean isBookingFlag() {
        return bookingFlag;
    }

    public void setBookingFlag(boolean bookingFlag) {
        this.bookingFlag = bookingFlag;
    }

    public boolean isDetailsFlag() {
        return detailsFlag;
    }

    public void setDetailsFlag(boolean detailsFlag) {
        this.detailsFlag = detailsFlag;
    }

    public double getHotelType() {
        return hotelType;
    }

    public void setHotelType(double hotelType) {
        this.hotelType = hotelType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRcount() {
        return rcount;
    }

    public void setRcount(double rcount) {
        this.rcount = rcount;
    }



    public double getRaw_recommended_hotel_wc() {
        return raw_recommended_hotel_wc;
    }

    public void setRaw_recommended_hotel_wc(double raw_recommended_hotel_wc) {
        this.raw_recommended_hotel_wc = raw_recommended_hotel_wc;
    }


    public double getImpressioncount() {
        return impressioncount;
    }

    public void setImpressioncount(double impressioncount) {
        this.impressioncount = impressioncount;
    }

    public double getDetailcount() {
        return detailcount;
    }

    public void setDetailcount(double detailcount) {
        this.detailcount = detailcount;
    }

    public double getBookingcount() {
        return bookingcount;
    }

    public void setBookingcount(double bookingcount) {
        this.bookingcount = bookingcount;
    }

    public double getUserimpressioncount() {
        return userimpressioncount;
    }

    public void setUserimpressioncount(double userimpressioncount) {
        this.userimpressioncount = userimpressioncount;
    }

    public double getUserdetailcount() {
        return userdetailcount;
    }

    public void setUserdetailcount(double userdetailcount) {
        this.userdetailcount = userdetailcount;
    }

    public double getUserbookingcount() {
        return userbookingcount;
    }

    public void setUserbookingcount(double userbookingcount) {
        this.userbookingcount = userbookingcount;
    }
}
