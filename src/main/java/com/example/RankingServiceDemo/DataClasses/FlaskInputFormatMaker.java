package com.example.RankingServiceDemo.DataClasses;


import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FlaskInputFormatMaker {
    private  Map<String , String> models = new HashMap<String, String>(){{
        this.put("2","LGBMModel");
        this.put( "11","LGBMModel_better");
        this.put("1","rfModel");
    }};
    public FlaskRequest createObjectES(List<Dataset> datasets, String cityid){

        FlaskRequest flaskRequest = null;
        Map<String, List<Object>> map = new HashMap<>();



        if(cityid.equals("1")) {


            for (int i = 0; i < datasets.size(); i++) {

                List<Object> doubleList = new ArrayList<>();

                doubleList.add(datasets.get(i).getFprice());
                doubleList.add(datasets.get(i).getHotelType());
                doubleList.add(datasets.get(i).getUser_abp());
                doubleList.add(datasets.get(i).getDiscountPer());
                doubleList.add(datasets.get(i).getHotel_btod());
                doubleList.add(datasets.get(i).getHotel_user_br());
                doubleList.add(datasets.get(i).getHotel_user_ctr());
                doubleList.add(datasets.get(i).getHotel_user_btod());
                doubleList.add(datasets.get(i).getAvg_user_rr());
                doubleList.add(datasets.get(i).isIs_weekend_checkin());
                doubleList.add(datasets.get(i).getRecom_score());
                doubleList.add(datasets.get(i).getRatingMean());
                doubleList.add(datasets.get(i).getRatingcount());
                doubleList.add(datasets.get(i).getHotel_placeid_ctr());
                doubleList.add(datasets.get(i).getHotel_placeid_br());
                doubleList.add(datasets.get(i).getHotel_placeid_dtob());
                doubleList.add(datasets.get(i).isIs_city_search());
                doubleList.add(datasets.get(i).getUser_cat_ctr());
                doubleList.add(datasets.get(i).getUser_cat_br());
                doubleList.add(datasets.get(i).getUser_cat_dtob());
                doubleList.add(datasets.get(i).getDistance());

                System.out.println(doubleList.get(i));
                map.put(datasets.get(i).getHotelid(), doubleList);


            }
            flaskRequest = new FlaskRequest(models.get(cityid), map);
        }
        else if(cityid.equals("11")){

            for (int i = 0; i < datasets.size(); i++) {
                List<Object> doubleList = new ArrayList<>();

                doubleList.add(datasets.get(i).getFprice());
                doubleList.add(datasets.get(i).getHotelType());
                doubleList.add(datasets.get(i).getUser_abp());
                doubleList.add(datasets.get(i).getDiscountPer());
                doubleList.add(datasets.get(i).getHotel_user_br());
                doubleList.add(datasets.get(i).getHotel_user_ctr());
                doubleList.add(datasets.get(i).getHotel_user_btod());
                doubleList.add(datasets.get(i).getAvg_user_rr());
                doubleList.add(datasets.get(i).isIs_weekend_checkin());
                doubleList.add(datasets.get(i).getRecom_score());
                doubleList.add(datasets.get(i).getRatingMean());
                doubleList.add(datasets.get(i).getRatingcount());
                doubleList.add(datasets.get(i).getHotel_placeid_ctr());
                doubleList.add(datasets.get(i).getHotel_placeid_br());
                doubleList.add(datasets.get(i).getHotel_placeid_dtob());
                doubleList.add(datasets.get(i).isIs_city_search());
                doubleList.add(datasets.get(i).isIs_locality_search());
                doubleList.add(datasets.get(i).getUser_cat_ctr());
                doubleList.add(datasets.get(i).getUser_cat_br());
                doubleList.add(datasets.get(i).getUser_cat_dtob());
                doubleList.add(datasets.get(i).getDistance());

                System.out.println(doubleList.get(i));
                map.put(datasets.get(i).getHotelid(), doubleList);


            }
            flaskRequest = new FlaskRequest(models.get(cityid), map);

        }
        else{
            System.out.println("  No model Exists");
        }

        return flaskRequest;

            //
//            JSONObject jsonObject = new JSONObject();
//            JSONObject nested = new JSONObject();
//
//            if(Model == "LGBMModel") {
//                jsonObject.put("model", "LGBMModel");
//            for (int i = 0; i < datasets.size(); i++) {
//                JSONArray jsonArray = new JSONArray();
//
//
//                jsonArray.add(datasets.get(i).getFprice());
//                jsonArray.add(datasets.get(i).getHotelType());
//                jsonArray.add(datasets.get(i).getUser_abp());
//                jsonArray.add(datasets.get(i).getDiscountPer());
//                jsonArray.add(datasets.get(i).getHotel_btod());
//                jsonArray.add(datasets.get(i).getHotel_user_br());
//                jsonArray.add(datasets.get(i).getHotel_user_ctr());
//                jsonArray.add(datasets.get(i).getHotel_user_btod());
//                jsonArray.add(datasets.get(i).getAvg_user_rr());
//                jsonArray.add(datasets.get(i).isIs_weekend_checkin());
//                jsonArray.add(datasets.get(i).getRecom_score());
//                jsonArray.add(datasets.get(i).getRatingMean());
//                jsonArray.add(datasets.get(i).getRatingcount());
//                jsonArray.add(datasets.get(i).getHotel_placeid_ctr());
//                jsonArray.add(datasets.get(i).getHotel_placeid_br());
//                jsonArray.add(datasets.get(i).getHotel_placeid_dtob());
//                jsonArray.add(datasets.get(i).isIs_city_search());
//                jsonArray.add(datasets.get(i).getUser_cat_ctr());
//                jsonArray.add(datasets.get(i).getUser_cat_br());
//                jsonArray.add(datasets.get(i).getUser_cat_dtob());
//                jsonArray.add(datasets.get(i).getDistance());


//                nested.put(datasets.get(i).getHotelid(), jsonArray);

//            }


//        }
//        else if(Model=="LGBMModel_better") {
//            jsonObject.put("model", "LGBMModel_better");
//
//
//            for (int i = 0; i < datasets.size(); i++) {
//                JSONArray jsonArray = new JSONArray();
//
//
//                jsonArray.add(datasets.get(i).getFprice());
//                jsonArray.add(datasets.get(i).getHotelType());
//                jsonArray.add(datasets.get(i).getUser_abp());
//                jsonArray.add(datasets.get(i).getDiscountPer());
//                jsonArray.add(datasets.get(i).getHotel_user_br());
//                jsonArray.add(datasets.get(i).getHotel_user_ctr());
//                jsonArray.add(datasets.get(i).getHotel_user_btod());
//                jsonArray.add(datasets.get(i).getAvg_user_rr());
//                jsonArray.add(datasets.get(i).isIs_weekend_checkin());
//                jsonArray.add(datasets.get(i).getRecom_score());
//                jsonArray.add(datasets.get(i).getRatingMean());
//                jsonArray.add(datasets.get(i).getRatingcount());
//                jsonArray.add(datasets.get(i).getHotel_placeid_ctr());
//                jsonArray.add(datasets.get(i).getHotel_placeid_br());
//                jsonArray.add(datasets.get(i).getHotel_placeid_dtob());
//                jsonArray.add(datasets.get(i).isIs_city_search());
//                jsonArray.add(datasets.get(i).isIs_locality_search());
//                jsonArray.add(datasets.get(i).getUser_cat_ctr());
//                jsonArray.add(datasets.get(i).getUser_cat_br());
//                jsonArray.add(datasets.get(i).getUser_cat_dtob());
//                jsonArray.add(datasets.get(i).getDistance());
//
//                nested.put(datasets.get(i).getHotelid(), jsonArray);
//
//            }
//
//        }
//
//        jsonObject.put("Data", nested);



    }



}
