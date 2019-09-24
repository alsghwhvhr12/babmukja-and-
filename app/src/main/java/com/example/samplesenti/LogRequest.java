package com.example.samplesenti;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LogRequest extends StringRequest {
    final static private  String URL= "http://babmukja.pe.kr/login.php";
    private Map<String,String> parameters;

    public LogRequest(String id, String password, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);

        parameters = new HashMap<>();
        parameters.put("id",id);
        parameters.put("password",password);
    }
    @Override
    protected  Map<String ,String> getParams() throws AuthFailureError{
        return parameters;
    }
}
