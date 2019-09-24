package com.example.samplesenti;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        final EditText etId = (EditText) findViewById(R.id.etId);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPhone = (EditText) findViewById(R.id.etPhone);
        final Button btnReg;

        btnReg = findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etId.getText().toString();
                String password = etPassword.getText().toString();
                String name = etName.getText().toString();
                String tel = etPhone.getText().toString();

            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        boolean success = jsonObject.getBoolean("success");
                        if (success) {
                            Toast.makeText(RegActivity.this,"회원등록에 성공 하셨습니다.",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(RegActivity.this,loginAct.class);
                            startActivity(intent);
                        }
                        else
                            {
                                Toast.makeText(RegActivity.this,"회원등록에 실패 하셨습니다.",Toast.LENGTH_SHORT).show();
                                return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };

                    //서버로 Volley를 이용해 요청
                    RegRequest registerRequest = new RegRequest(id,password,name,tel,responseListener);
                    RequestQueue queue =Volley.newRequestQueue(RegActivity.this);
                    queue.add(registerRequest);
                };
            });
        }
    }
