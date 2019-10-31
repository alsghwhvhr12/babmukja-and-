//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.model;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class mRegister extends StringRequest {

    private Map<String,String> parameters;

    public mRegister(String company_no,String k_id, String name, String price, Response.Listener<String> listener)
    {
        super(Request.Method.POST,ServerURL.URL6,listener,null);
        parameters = new HashMap<>();
        parameters.put("company_no",company_no);
        parameters.put("k_id",k_id);
        parameters.put("name",name);
        parameters.put("price",price);
    }

    @Override
    public Map<String,String> getParams(){
        return parameters;
    }
}
