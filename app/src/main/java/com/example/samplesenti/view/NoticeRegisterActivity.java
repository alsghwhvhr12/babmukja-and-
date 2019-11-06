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
import com.example.samplesenti.model.nRegister;
import com.example.samplesenti.presenter.NoticeRegisterPresenter;

import org.json.JSONException;
import org.json.JSONObject;

public class NoticeRegisterActivity extends AppCompatActivity implements INoticeRegisterActivity.View, View.OnClickListener{

    private INoticeRegisterActivity.Presenter presenter;

    public EditText nTitle;
    public EditText nNotice;

    public Button nRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_register);

        presenter = new NoticeRegisterPresenter(NoticeRegisterActivity.this, getApplicationContext(),this);
        presenter.presenterView();

        Toolbar mToolbar = (Toolbar) findViewById(R.id.noRtb);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setView() {
        //버튼
        nRegBtn = (Button)findViewById(R.id.nRegBtn);
        nRegBtn.setOnClickListener(this);
        //텍스트
        nTitle=(EditText)findViewById(R.id.nTitle);
        nNotice=(EditText)findViewById(R.id.nNotice);
    }

    @Override
    public void onClick(View v) {

        final String Title = nTitle.getText().toString();
        final String Notice = nNotice.getText().toString();
        switch (v.getId()){
            case R.id.nRegBtn:
                if(Title.length()>5)
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
                    nRegister register = new nRegister(Title,Notice,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(NoticeRegisterActivity.this);
                    queue.add(register);
                    Toast.makeText(getApplicationContext(),"true.",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),AdminMainActivity.class);
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
