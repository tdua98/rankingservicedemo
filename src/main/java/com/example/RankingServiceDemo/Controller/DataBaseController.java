package com.example.RankingServiceDemo.Controller;


import com.example.RankingServiceDemo.DataBases.ES.ESrepository;
import com.example.RankingServiceDemo.DataBases.Redis.RedisRepository;
import com.example.RankingServiceDemo.DataClasses.Dataset;
import com.example.RankingServiceDemo.DataClasses.HotelData;
import com.example.RankingServiceDemo.Schedular.EStoRedisDataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/data")
public class DataBaseController {


    @Autowired
    private ESrepository eSrepository;

    @Autowired
    private RedisRepository redisRepository;
    @Autowired
    EStoRedisDataTransfer eStoRedisDataTransfer;

//    @RequestMapping(method = RequestMethod.GET, value = "/ES/exist/{id}")
//    public boolean exist(@PathVariable String id)
//    {
//        return eSrepository.existById(id);
//    }
    @RequestMapping(method = RequestMethod.POST,value = "/ES/save/{type}")
    public String saveToEs(@RequestBody HotelData hotelData, @PathVariable String type){
        return eSrepository.save(hotelData,type);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/ES/update/{type}")
    public String UpdateToEs(@RequestBody HotelData hotelData, @PathVariable String type) {
        return eSrepository.UpdateData(hotelData,type);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/ES/delete/{type}")
    public String DeleteFromEs(@RequestBody String s, @PathVariable String type) {
        return eSrepository.DeleteData(s,type);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/ES/getall")
    public List<HotelData> getAll() throws IOException {
        return eSrepository.getAllHotels();
    }

    @RequestMapping(value = "/Redis/save",method = RequestMethod.POST)
    public HotelData saveToRedis(@RequestBody HotelData hotelData){
        return (HotelData) redisRepository.save(hotelData);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/Redis/delete")
    public void DeleteFromRedis(@RequestBody String s) {
        redisRepository.deleteById(s);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Redis/update")
    public HotelData UpdateToRedis(@RequestBody HotelData hotelData) {
        redisRepository.deleteById(hotelData.getHotelid());
        return (HotelData) redisRepository.save(hotelData);
    }




}
