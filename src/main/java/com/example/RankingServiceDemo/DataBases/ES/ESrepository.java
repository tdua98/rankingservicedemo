package com.example.RankingServiceDemo.DataBases.ES;


import com.example.RankingServiceDemo.DataClasses.Dataset;
import com.example.RankingServiceDemo.DataClasses.RankingRequest;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ESrepository {

    @Autowired
    private JestClient jestClient;



    public List<Dataset> getAllDataById(List<String> hotelIds){

        String queryDSL = "{"+
                " \"query\":{"+
                " \"terms\":"+
                "{ \"hotelid\": [";
        for(String x:hotelIds){
            queryDSL = queryDSL+"\""+x+"\",";
        }
        queryDSL = queryDSL.substring(0,queryDSL.length()-1);
        queryDSL=queryDSL+"]}}}";
        List<Dataset> result = new LinkedList<>();
        try {
             result = jestClient.execute(new Search.Builder(queryDSL).build()).getSourceAsObjectList(Dataset.class);
//                if (!lol.isSucceeded()) {
//                    p.get(0).requestid = lol.getErrorMessage();
//                    p.get(0).hotelid = queryDSL;
//                    return p;
//                }
        }
        catch (Exception e){
//                p.get(0).requestid = e.toString();
            System.out.println(e);
            return result;
        }
        return result;
    }


    public List<Dataset> getAllHotels() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery()).size(1000);


        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex("hotelid")
                .addType("k")
                .build();
        List<Dataset> results=null;
        try {
            SearchResult searchResult = jestClient.execute(search);
            List<SearchResult.Hit<Dataset, Void>> searchHits = searchResult.getHits(Dataset.class);
            results = searchHits.stream()
                    .map(h -> h.source)
                    .collect(Collectors.toList());
        }
        catch(Exception e){
            System.out.println("Error: "+e);
            throw e;
        }
        jestClient.close();
        return results;
    }

    public String save(Dataset dataset){
        System.out.println(dataset.getHotelid()+ dataset.getAvg_user_rr() + dataset.getFprice());
        try{
            JestResult jestResult = jestClient.execute(new Index.Builder(dataset).index("hotelid").type("k").build());
        }
        catch(Exception e){ return e.toString();}

        return "done!";
    }

    public Dataset getDataById(String s){

        Dataset getResult=null;
        try{
            getResult = jestClient.execute(new Get.Builder("hotelid", s).type("k").build()).getSourceAsObject(Dataset.class);
        }
        catch (Exception e){ System.out.println(e);}

        return getResult;
    }



    public String UpdateData(Dataset dataset)
    {
        try{
            JestResult jestResult = jestClient.execute(new Update.Builder(dataset).index("hotelid").type("k").build());
            return "success!";
        }
        catch (Exception e){ System.out.println(e);}

        return "Failed..";
    }

    public  String DeleteData(String s)
    {
        try{
            JestResult jestResult = jestClient.execute(new Delete.Builder(s).index("hotelid").type("k").build());
            return "Success!!";
        }
        catch (Exception e){ System.out.println(e); }

        return "Failed..";
    }


}
