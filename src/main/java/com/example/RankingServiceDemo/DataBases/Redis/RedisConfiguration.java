package com.example.RankingServiceDemo.DataBases.Redis;

import com.example.RankingServiceDemo.DataClasses.Dataset;
import com.example.RankingServiceDemo.DataClasses.HotelData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(){return new LettuceConnectionFactory();}
    @Bean
    public RedisTemplate<String, HotelData> redisTemplate(){
        final RedisTemplate<String,HotelData> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Dataset.class));
        return redisTemplate;
    }
}
