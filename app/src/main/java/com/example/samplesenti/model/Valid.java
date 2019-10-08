package com.example.samplesenti.model;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Valid extends StringRequest {

    private Map<String,String> parameters;

    public Valid(String id, Response.Listener<String>listener)
    {
        super(Request.Method.POST,ServerURL.URL3,listener,null);
        parameters = new HashMap<>();
        parameters.put("id",id);
    }
    public Map<String,String> getParams(){
        return parameters;
    }

}
