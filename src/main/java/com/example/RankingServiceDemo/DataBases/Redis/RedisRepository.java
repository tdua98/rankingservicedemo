package com.example.RankingServiceDemo.DataBases.Redis;



import com.example.RankingServiceDemo.DataClasses.HotelData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<HotelData, String> {

}
