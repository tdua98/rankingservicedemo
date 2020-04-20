package com.example.RankingServiceDemo.DataManipulation;

import com.example.RankingServiceDemo.DataClasses.Dataset;
import com.example.RankingServiceDemo.DataClasses.HotelData;
import com.example.RankingServiceDemo.DataClasses.RankingRequest;
import com.example.RankingServiceDemo.DataClasses.UserData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataPreprocessing {

    public List<Dataset> dataCleaning(List<HotelData> hotelDataList, UserData userData, RankingRequest rankingRequest){
        List<Dataset> datasetList = new ArrayList<>();

        for(HotelData hotelData: hotelDataList) {
            Dataset dataset = new Dataset();
            dataset.setHotelid(hotelData.getHotelid());
            dataset.setUserid(userData.getUserid());
            dataset.setFprice(hotelData.getFprice());
            dataset.setHotelType(hotelData.getHotelType());
            dataset.setUser_abp(userData.getUser_abp());
            dataset.setRecom_score(hotelData.getRaw_recommended_hotel_wc());
            dataset.setRatingcount(hotelData.getRcount());
            dataset.setRatingMean(hotelData.getRating());
            dataset.setDistance(hotelData.getDistance());
            dataset.setIs_weekend_checkin(rankingRequest.isIs_weekend_checkin());
            dataset.setUser_cat_br(hotelData.getUser_cat_br());
            dataset.setUser_cat_ctr(hotelData.getUser_cat_ctr());
            dataset.setUser_cat_dtob(hotelData.getUser_cat_dtob());
            dataset.setAvg_user_rr(hotelData.getAvg_user_rr());
            dataset.setIs_city_search(rankingRequest.isCitySearch());
            dataset.setHotel_placeid_br(hotelData.getHotel_placeid_br());
            dataset.setHotel_placeid_ctr(hotelData.getHotel_placeid_ctr());
            dataset.setHotel_placeid_dtob(hotelData.getHotel_placeid_dtob());
            dataset.setIs_locality_search(rankingRequest.isCitySearch() == false && rankingRequest.isNearbysearch() == false ? true : false);
            dataset.setDiscountPer(hotelData.getHotelslasherprice() == 0 ? 0 : ((hotelData.getHotelslasherprice() - hotelData.getFprice()) / hotelData.getHotelslasherprice()));
            dataset.setHotel_btod(hotelData.getDetailcount() == 0 ? 0 : hotelData.getBookingcount() / hotelData.getDetailcount());
            dataset.setHotel_user_br(hotelData.getUserimpressioncount() == 0 ? 0 : hotelData.getUserbookingcount() / hotelData.getUserimpressioncount());
            dataset.setHotel_user_ctr(hotelData.getUserimpressioncount() == 0 ? 0 : hotelData.getUserdetailcount() / hotelData.getUserimpressioncount());
            dataset.setHotel_user_btod(hotelData.getUserdetailcount() == 0 ? 0 : hotelData.getUserbookingcount() / hotelData.getUserdetailcount());

            datasetList.add(dataset);
        }
        return datasetList;
    }


}
