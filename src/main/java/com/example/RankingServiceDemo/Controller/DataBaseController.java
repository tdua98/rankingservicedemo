package com.example.RankingServiceDemo.Controller;


import com.example.RankingServiceDemo.DataBases.ES.ESrepository;
import com.example.RankingServiceDemo.DataBases.Redis.RedisRepository;
import com.example.RankingServiceDemo.DataClasses.Dataset;
import com.example.RankingServiceDemo.Schedular.EStoRedisDataTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "/data")
public class DataBaseController {


    @Autowired
    private ESrepository eSrepository;

    @Autowired
    private RedisRepository redisRepository;


    @RequestMapping(method = RequestMethod.POST,value = "/ES/save")
    public String saveToEs(@RequestBody Dataset dataset){
        return eSrepository.save(dataset);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/ES/update")
    public String UpdateToEs(@RequestBody Dataset dataset) {
        return eSrepository.UpdateData(dataset);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/ES/delete")
    public String DeleteFromEs(@RequestBody String s) {
        return eSrepository.DeleteData(s);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/ES/getall")
    public List<Dataset> getAll() throws IOException {
        return eSrepository.getAllHotels();
    }

    @RequestMapping(value = "/Redis/save",method = RequestMethod.POST)
    public Dataset saveToRedis(@RequestBody Dataset dataset){
        return (Dataset) redisRepository.save(dataset);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/Redis/delete")
    public void DeleteFromRedis(@RequestBody String s) {
        redisRepository.deleteById(s);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Redis/update")
    public Dataset UpdateToRedis(@RequestBody Dataset dataset) {
        redisRepository.deleteById(dataset.getHotelid());
        return (Dataset) redisRepository.save(dataset);
    }

}
