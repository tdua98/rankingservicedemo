package com.example.RankingServiceDemo.DataBases.Redis;



import com.example.RankingServiceDemo.DataClasses.Dataset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<Dataset, String> {

}
