package com.example.RankingServiceDemo.Handler;


import com.example.RankingServiceDemo.DataClasses.*;
import com.example.RankingServiceDemo.DataExtraction.DataFetcher;
import com.example.RankingServiceDemo.DataManipulation.DataPreprocessing;
import com.example.RankingServiceDemo.DataClasses.HotelData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@Component
public class RankingServiceHandler {

    private static List<String> sortByValue(Map<String, Double> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double> > list =
                new LinkedList<Map.Entry<String, Double> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Double> >() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        List<String> response = new ArrayList<>();

        //put the sorted list into list
        for (Map.Entry<String, Double> aa : list) {
            response.add(aa.getKey());

        }
        return response;
    }


    @Autowired
    private DataFetcher dataFetcher;
    @Autowired
    private FlaskInputFormatMaker flaskInputFormatMaker;
    @Autowired
    private DataPreprocessing dataPreprocessing;
    @Autowired
    private RestTemplate restTemplate;

//    @Value("${server.url}")
//    private String url;


    public RankingResponse manageRanking(RankingRequest rankingRequest ) throws JsonProcessingException {

        //Fetching data from the database
        List<HotelData> hotelData = dataFetcher.fetchDataFromDB(rankingRequest);

        UserData userData = new UserData("20458612",1493.89);

        List<Dataset> data = dataPreprocessing.dataCleaning(hotelData,userData, rankingRequest);


        //converting the data into json for in the format according to flask's need
        FlaskRequest dataForFlask = flaskInputFormatMaker.createObjectES(data,rankingRequest.getCityid());


        //Connection With Flask
        String scores;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<FlaskRequest> httpEntity = new HttpEntity<FlaskRequest>(dataForFlask, headers);
            scores = restTemplate.exchange("http://localhost:5000/predict",
                    HttpMethod.POST,
                    httpEntity,
                    String.class).getBody();
        }
        catch (Exception e){
            System.out.println("This is the error "+e);
            throw e;
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Double> mapResponse = mapper.readValue(scores, Map.class);

        RankingResponse rankingResponse = new RankingResponse(sortByValue(mapResponse));

        return rankingResponse;
    }

}
