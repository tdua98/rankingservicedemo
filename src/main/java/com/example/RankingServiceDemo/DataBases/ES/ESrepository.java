package com.example.RankingServiceDemo.DataBases.ES;


import com.example.RankingServiceDemo.DataClasses.HotelData;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ESrepository {

    @Autowired
    private JestClient jestClient;



    public List<HotelData> getAllDataById(List<String> hotelIds){

        String queryDSL = "{"+
                " \"query\":{"+
                " \"terms\":"+
                "{ \"hotelid\": [";
        for(String x:hotelIds){
            queryDSL = queryDSL+"\""+x+"\",";
        }
        queryDSL = queryDSL.substring(0,queryDSL.length()-1);
        queryDSL=queryDSL+"]}}}";
        List<HotelData> result = new LinkedList<>();
        try {
             result = jestClient.execute(new Search.Builder(queryDSL).addIndex("hotelid").addType("ranking").build()).getSourceAsObjectList(HotelData.class);
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

//    public boolean existById(String id){
//
//        String queryDSL = "{\"size\": 0,"+
//                " \"query\":{"+
//                " \"match\":"+
//                "{ \"hotelid\": "+
//                "\""+id+"\""+
//                "}}}";
//        JestResult lol = null;
//        try{
//            lol =  jestClient.execute(new Search.Builder(queryDSL).build());
//                if (!lol.isSucceeded()) {
//                    System.out.println(lol.getJsonObject());
//                }
//                System.out.println("ans  " + lol.getSourceAsObject(HotelData.class));
//        }
//        catch (Exception e){
////                p.get(0).requestid = e.toString();
//            System.out.println(e);
//            return false;
//        }
//        return true
//                ;
//    }

    public List<HotelData> getAllHotels() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery()).size(1000);


        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex("hotelid")
                .build();
        List<HotelData> results=null;
        try {
            SearchResult searchResult = jestClient.execute(search);
            List<SearchResult.Hit<HotelData, Void>> searchHits = searchResult.getHits(HotelData.class);
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


    public String save(HotelData hotelData, String type){
        System.out.println(hotelData.getHotelid()+ hotelData.getAvg_user_rr() + hotelData.getFprice());
        try{
            JestResult jestResult = jestClient.execute(new Index.Builder(hotelData).index("hotelid").type(type).build());
        }
        catch(Exception e){ return e.toString();}

        return "done!";
    }

    public HotelData getDataById(String s, String type){

        HotelData getResult=null;
        try{
            getResult = jestClient.execute(new Get.Builder("hotelid", s).type(type).build()).getSourceAsObject(HotelData.class);
        }
        catch (Exception e){ System.out.println(e);}

        return getResult;
    }



    public String UpdateData(HotelData hotelData , String type)
    {
        try{
            JestResult jestResult = jestClient.execute(new Update.Builder(hotelData).index("hotelid").type(type).build());
            return "success!";
        }
        catch (Exception e){ System.out.println(e);}

        return "Failed..";
    }

    public  String DeleteData(String s, String type)
    {
        try{
            JestResult jestResult = jestClient.execute(new Delete.Builder(s).index("hotelid").type(type).build());
            return "Success!!";
        }
        catch (Exception e){ System.out.println(e); }

        return "Failed..";
    }


}
