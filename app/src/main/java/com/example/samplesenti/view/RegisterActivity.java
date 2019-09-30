//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.samplesenti.R;
import com.example.samplesenti.model.Register;
import com.example.samplesenti.presenter.RegisterPresenter;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity implements RegisterInterface.View, View.OnClickListener {

    private RegisterInterface.Presenter presenter;

    public EditText idEdit;
    public EditText passwordEdit;
    public EditText passwordCheckEdit;

    public Button regist;
    public Button loginBtn;
    public Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new RegisterPresenter(RegisterActivity.this,getApplicationContext(),this);
        presenter.presenterView();
    }

    @Override
    public void setView() {
        //버튼
        loginBtn = (Button)findViewById(R.id.loginBtn);
        registerBtn = (Button)findViewById(R.id.registerBtn);
        regist=(Button)findViewById(R.id.regist);
        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        regist.setOnClickListener(this);
        //텍스트
        idEdit=(EditText)findViewById(R.id.idEdit);
        passwordEdit=(EditText)findViewById(R.id.passwordEdit);
        passwordCheckEdit=(EditText)findViewById(R.id.passwordCheckEdit);


    }

    @Override
    public void onClick(View v) {

        final String id = idEdit.getText().toString();
        final String pw = passwordEdit.getText().toString();
        switch (v.getId()){
            case R.id.loginBtn:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.registerBtn:
                break;

            case R.id.regist:
                if(idEdit.length()>5&&passwordEdit.getText().toString().equals(passwordCheckEdit.getText().toString()))
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
                    Register register = new Register(id,pw,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(register);
                    Toast.makeText(getApplicationContext(),"true.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}