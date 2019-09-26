package com.example.samplesenti;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        final EditText etId  = (EditText) findViewById(R.id.etId);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPhone = (EditText) findViewById(R.id.etPhone);
        Button btnReg= (Button) findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String id=etId.getText().toString();
                String pw=etPassword.getText().toString();
                String tel=etPhone.getText().toString();
                String name=etName.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      try{
                          JSONObject jsonResponse = new JSONObject(response);
                          boolean success=jsonResponse.getBoolean("success");
                          if(success){
                              AlertDialog.Builder builder = new AlertDialog.Builder(RegActivity.this);
                          builder.setMessage("등록 성공");
                          builder.setPositiveButton("확인",null);
                          builder.create()
                                  .show();
                          Intent intent = new Intent(RegActivity.this,loginAct.class);
                          RegActivity.this.startActivity(intent);
                          }
                          else
                          {
                              AlertDialog.Builder builder = new AlertDialog.Builder(RegActivity.this);
                              builder.setMessage("등록 실패");
                              builder.setNegativeButton("실패",null);
                              builder.create()
                                      .show();
                          }
                      }
                      catch (JSONException e)
                      {
                          e.printStackTrace();
                      }
                    }
                };
                RegRequest regRequest = new RegRequest(id,pw,name,tel,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegActivity.this);
                queue.add(regRequest);
            }
        });
    }
}
