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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.samplesenti.R;
import com.example.samplesenti.model.Register;
import com.example.samplesenti.model.Valid;
import com.example.samplesenti.presenter.RegisterPresenter;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity implements RegisterInterface.View, View.OnClickListener {

    private RegisterInterface.Presenter presenter;

    public EditText idEdit;
    public EditText passwordEdit;
    public EditText passwordCheckEdit;
    public EditText idName;

    public Button regist;
    public Button loginBtn;
    public Button valid;

    private AlertDialog dialog;
    boolean validate = false;

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
        regist=(Button)findViewById(R.id.regist);
        loginBtn.setOnClickListener(this);
        regist.setOnClickListener(this);
        valid=(Button)findViewById(R.id.btnValid);
        valid.setOnClickListener(this);
        //텍스트
        idEdit=(EditText)findViewById(R.id.idEdit);
        idName=(EditText)findViewById(R.id.idName);
        passwordEdit=(EditText)findViewById(R.id.passwordEdit);
        passwordCheckEdit=(EditText)findViewById(R.id.passwordCheckEdit);


    }

    @Override
    public void onClick(View v) {

        final String id = idEdit.getText().toString();
        final String pw = passwordEdit.getText().toString();
        final String name = idName.getText().toString();

        switch (v.getId()){
            case R.id.loginBtn:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.regist:
                if(validate=true
                        &&idEdit.length()>5
                        &&idName.length()>2
                        &&passwordEdit.getText().toString().equals(passwordCheckEdit.getText().toString()))
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
                    Register register = new Register(id,pw,name,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(register);
                    Toast.makeText(getApplicationContext(),"true.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnValid:
                if(validate){
                return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success
                                    &&idEdit.length()>5){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog = builder.setMessage("사용 가능한 아이디 입니다.")
                                        .setPositiveButton("OK",null)
                                        .create();
                                dialog.show();
                                idEdit.setEnabled(false);
                                validate=true;
                                idEdit.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                valid.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog=builder.setMessage("이미 사용중 이거나 짧습니다.")
                                        .setNegativeButton("OK",null)
                                        .create();
                                dialog.show();;
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                Valid valid = new Valid(id,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(valid);
                break;
        }
    }


}