package com.example.samplesenti;

import androidx.appcompat.app.AppCompatActivity;

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
import java.*;

public class loginAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etId  = (EditText) findViewById(R.id.etId);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        Button btnReg= (Button) findViewById(R.id.btnReg);
        Button btn_go = (Button) findViewById(R.id.btnLogin);
        Button btnFind = (Button) findViewById(R.id.btnFind) ;

        btn_go.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                final String id = etId.getText().toString();
                String password = etPassword.toString();
                //회원가입

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                String id = jsonObject.getString("id");
                                String password=jsonObject.getString("password");
                                Toast.makeText(getApplicationContext(),"로그인 성공 하셨습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent =new Intent(loginAct.this,MainActivity.class);
                                intent.putExtra("id",id);
                                intent.putExtra("password",password);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"로그인 실패 하셨습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LogRequest loginRequest = new LogRequest(id,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(loginAct.this);
                queue.add(loginRequest);
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(loginAct.this, RegActivity.class);
                loginAct.this.startActivity(registerintent);
            }
        });

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent findintent = new Intent(loginAct.this, FindMyInfo.class);
                loginAct.this.startActivity(findintent);
            }
        });

    }
}
