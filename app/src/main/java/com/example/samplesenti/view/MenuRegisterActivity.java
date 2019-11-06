//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.samplesenti.R;
import com.example.samplesenti.model.mRegister;
import com.example.samplesenti.presenter.MenuRegisterPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuRegisterActivity extends AppCompatActivity implements IMenuRegisterActivity.View, View.OnClickListener{

    private IMenuRegisterActivity.Presenter presenter;

    public EditText mCompany_no;
    public EditText mName;
    public EditText mPrice;
    public Spinner spinner;
    public Spinner spinner2;

    public ArrayList<String> list3;

    public Button mRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_register);

        presenter = new MenuRegisterPresenter(MenuRegisterActivity.this, getApplicationContext(),this);
        presenter.presenterView();

        Intent intent = getIntent();

        ArrayList<String> list = new ArrayList<>();
        list.add("학식A");
        list.add("학식B");
        list.add("학식C");
        list.add("민들레뜨락");
        list.add("피자굽는오빠");

        ArrayList<String> list2 = new ArrayList<>();
        list3 = new ArrayList<>();

        try{
            //intent로 값을 가져옵니다 이때 JSONObject타입으로 가져옵니다
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("companyList"));


            //List.php 웹페이지에서 response라는 변수명으로 JSON 배열을 만들었음..
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;

            String mCompany_no, mName;

            //JSON 배열 길이만큼 반복문을 실행
            while(count < jsonArray.length()){
                //count는 배열의 인덱스를 의미
                JSONObject object = jsonArray.getJSONObject(count);

                mCompany_no = object.getString("no");//여기서 ID가 대문자임을 유의
                mName = object.getString("name");

                list2.add(mName);//리스트뷰에 값을 추가해줍니다
                list3.add(mCompany_no);
                count++;
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        ArrayAdapter spinnerAdapter;
        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
        spinner2.setAdapter(spinnerAdapter);

        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list2);
        spinner.setAdapter(spinnerAdapter);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.meRtb);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setView() {
        //버튼
        mRegBtn = (Button)findViewById(R.id.mRegBtn);
        mRegBtn.setOnClickListener(this);
        //텍스트
        mName=(EditText)findViewById(R.id.mName);
        mPrice=(EditText)findViewById(R.id.mPrice);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner2=(Spinner)findViewById(R.id.spinner2);
    }

    @Override
    public void onClick(View v) {

        final String Company_no = list3.get(spinner.getSelectedItemPosition());
        final String Name = mName.getText().toString();
        final String Price = mPrice.getText().toString();
        final String K_id = String.valueOf(spinner2.getSelectedItemPosition()+1);
        switch (v.getId()){
            case R.id.mRegBtn:
                if(mName.length()>2)
                {
                    Response.Listener<String> responseListener = new Response.Listener<String>(){
                        public  void onResponse(String response){
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                            }catch(JSONException e){
                                e.printStackTrace();
                            }
                        }
                    };
                    mRegister register = new mRegister(Company_no,K_id,Name,Price,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(MenuRegisterActivity.this);
                    queue.add(register);
                    Toast.makeText(getApplicationContext(),"true.",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),CompanyMainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
