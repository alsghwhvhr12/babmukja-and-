package com.example.samplesenti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.samplesenti.view.MainActivity;
import com.example.samplesenti.view.RegActivity;

public class loginAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText etId  = (EditText) findViewById(R.id.etId);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        Button btnReg= (Button) findViewById(R.id.btnReg);
        Button btn_go = (Button) findViewById(R.id.btnLogin);
        Button btnFind = (Button) findViewById(R.id.btnFind) ;

        btn_go.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        //로그인화면
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        //액티비티 시작
                        startActivity(intent);
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
