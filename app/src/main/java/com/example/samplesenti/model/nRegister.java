package com.example.samplesenti.model;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class nRegister extends StringRequest {
    private Map<String,String> parameters;

    public nRegister(String title, String notice, Response.Listener<String> listener)
    {
        super(Request.Method.POST,ServerURL.URL4,listener,null);
        parameters = new HashMap<>();
        parameters.put("title",title);
        parameters.put("notice",notice);
    }

    @Override
    public Map<String,String> getParams(){
        return parameters;
    }

}
