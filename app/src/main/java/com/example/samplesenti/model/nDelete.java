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

public class nDelete extends StringRequest {

    private Map<String, String> parameters;

    public nDelete(String no, Response.Listener<String> listener)
    {
        super(Request.Method.POST,ServerURL.URL5,listener,null);
        parameters = new HashMap<>();
        parameters.put("no",no);
    }

    @Override
    public Map<String,String> getParams(){
        return parameters;
    }

}
