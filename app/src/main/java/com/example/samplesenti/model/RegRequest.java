package com.example.samplesenti.model;
import java.util.*;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.Map;
import java.util.HashMap;

public class RegRequest extends  StringRequest {

final static private  String URL= "http://babmukja.pe.kr/reg.php";
private Map<String,String> parameters;

public RegRequest(String id, String pw, String name, String tel , Response.Listener<String> listener)
{
    super(Method.POST,URL,listener,null);
    parameters = new HashMap<>();
    parameters.put("id",id);
    parameters.put("pw",pw);
    parameters.put("name",name);
    parameters.put("tel",tel);
}
@Override
public Map<String,String> getParams(){
    return parameters;
}
}
