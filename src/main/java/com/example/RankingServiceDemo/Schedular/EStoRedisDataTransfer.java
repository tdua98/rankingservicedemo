package com.example.RankingServiceDemo.Schedular;

import com.example.RankingServiceDemo.DataBases.ES.ESrepository;
import com.example.RankingServiceDemo.DataBases.Redis.RedisRepository;
import com.example.RankingServiceDemo.DataClasses.Dataset;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class EStoRedisDataTransfer {
    @Autowired
    private RedisRepository redisRepository;
    @Autowired
    private ESrepository eSrepository;

    @Scheduled(cron="0 12 * * * ?")
    public void  DataTransfer() throws IOException {
        redisRepository.saveAll(eSrepository.getAllHotels());
    }

}
