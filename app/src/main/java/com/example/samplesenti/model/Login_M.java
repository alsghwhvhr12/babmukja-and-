//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.model;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Login_M extends StringRequest {
    private Map<String,String> parameters;

    public Login_M(String id, String pw, Response.Listener<String> listener){
        super(Method.POST, ServerURL.URL2,listener,null);

        parameters = new HashMap<>();
        parameters.put("id",id);
        parameters.put("pw",pw);
    }
    @Override
    protected  Map<String ,String> getParams() throws AuthFailureError {
        return parameters;
    }
}
