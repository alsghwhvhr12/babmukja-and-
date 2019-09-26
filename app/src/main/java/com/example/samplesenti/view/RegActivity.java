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
import com.example.samplesenti.model.RegRequest;
import com.example.samplesenti.presenter.IRegActPresenter;
import com.example.samplesenti.presenter.RegActPresenter;

import org.json.JSONException;
import org.json.JSONObject;

public class RegActivity extends AppCompatActivity implements IRegActView {
    IRegActPresenter RegActPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        final EditText etId = (EditText) findViewById(R.id.etId);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPhone = (EditText) findViewById(R.id.etPhone);
       final Button btnReg = (Button) findViewById(R.id.btnReg);
        RegActPresenter = new RegActPresenter(this);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               final String id = etId.getText().toString();
               final String pw = etPassword.getText().toString();
               final String tel = etPhone.getText().toString();
               final String name = etName.getText().toString();

                btnReg.setOnClickListener(new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       final boolean chk = RegActPresenter.onReg(id, pw, name, tel);
                            Response.Listener<String> responseListener = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try{
                                        JSONObject jsonResponse = new JSONObject(response);
                                        boolean success=jsonResponse.getBoolean("success");
                                        if(chk){
                                            AlertDialog.Builder builder = new AlertDialog.Builder(RegActivity.this);
                                            builder.setMessage("등록 성공")
                                                    .setPositiveButton("확인",null)
                                                    .create()
                                                    .show();
                                            if(success) {
                                                Intent intent = new Intent(RegActivity.this, loginAct.class);
                                                RegActivity.this.startActivity(intent);
                                            }
                                            else
                                            {
                                                return ;
                                            }
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
        });
        }
    @Override
    public void onRegResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}