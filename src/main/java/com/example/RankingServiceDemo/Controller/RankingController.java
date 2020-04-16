package com.example.RankingServiceDemo.Controller;


import com.example.RankingServiceDemo.DataClasses.RankingRequest;
import com.example.RankingServiceDemo.DataClasses.RankingResponse;
import com.example.RankingServiceDemo.Handler.RankingServiceHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/rank")
//@ExceptionHandler
public class RankingController{


    @Autowired
    private RankingServiceHandler rankingServiceHandler ;

    @RequestMapping(method = RequestMethod.POST, value = "/hotels")
    public RankingResponse Ranking(@Valid @RequestBody RankingRequest rankingRequest) throws JsonProcessingException {
        return rankingServiceHandler.manageRanking(rankingRequest);
    }

}
