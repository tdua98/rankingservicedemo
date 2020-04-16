package com.example.RankingServiceDemo.DataClasses;

import java.util.List;
import java.util.Map;

public class FlaskRequest {
    private String model;
    private Map<String, List<Object>> Data;

    public FlaskRequest(String model, Map<String, List<Object>> Data) {
        this.model = model;
        this.Data = Data;
    }

    public Map<String, List<Object>> getData() {
        return Data;
    }

    public void setData(Map<String, List<Object>> Data) {
        this.Data = Data;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
