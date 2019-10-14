//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.samplesenti.R;
import com.example.samplesenti.model.mRegister;
import com.example.samplesenti.presenter.MenuRegisterPresenter;

import org.json.JSONException;
import org.json.JSONObject;

public class MenuRegisterActivity extends AppCompatActivity implements IMenuRegisterActivity.View, View.OnClickListener{

    private IMenuRegisterActivity.Presenter presenter;

    public EditText mCompany_no;
    public EditText mName;
    public EditText mPrice;

    public Button mRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_register);

        presenter = new MenuRegisterPresenter(MenuRegisterActivity.this, getApplicationContext(),this);
        presenter.presenterView();

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
        mCompany_no=(EditText)findViewById(R.id.mCompany_no);
        mName=(EditText)findViewById(R.id.mName);
        mPrice=(EditText)findViewById(R.id.mPrice);
    }

    @Override
    public void onClick(View v) {

        final String Company_no = mCompany_no.getText().toString();
        final String Name = mName.getText().toString();
        final String Price = mPrice.getText().toString();
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
                    mRegister register = new mRegister(Company_no,Name,Price,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(MenuRegisterActivity.this);
                    queue.add(register);
                    Toast.makeText(getApplicationContext(),"true.",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),CompanyMainActivity.class);
                    startActivity(intent);
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
