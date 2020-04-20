package com.example.RankingServiceDemo.DataExtraction;

import com.example.RankingServiceDemo.DataBases.ES.ESrepository;
import com.example.RankingServiceDemo.DataBases.Redis.RedisRepository;
import com.example.RankingServiceDemo.DataClasses.RankingRequest;
import com.example.RankingServiceDemo.DataClasses.HotelData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataFetcher {

    @Autowired
    private ESrepository eSrepository;
    @Autowired
    RedisRepository redisRepository;

    public List<HotelData> fetchDataFromDB(RankingRequest rankingRequest)
    {
        List<HotelData> hotelDataList =null;
        List<String> RedisList = new ArrayList<>();
        List<String> EsList = new ArrayList<>();


        rankingRequest.getHotelids().forEach(
                n-> {
                    if (redisRepository.existsById(n)) {
                        RedisList.add(n);
                    } else {
                        EsList.add(n);
                    }
                }
        );
        hotelDataList = (List<HotelData>) redisRepository.findAllById(RedisList);
        hotelDataList.addAll(eSrepository.getAllDataById(EsList));

        return  hotelDataList;
    }


}
