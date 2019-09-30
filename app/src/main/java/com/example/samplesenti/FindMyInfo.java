package com.example.samplesenti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.samplesenti.view.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class FindMyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_my_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //선언
        EditText etId  = (EditText) findViewById(R.id.etId);
        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etPhone = (EditText) findViewById(R.id.etPhone);
        EditText etPhonee = (EditText) findViewById(R.id.etPhonee);
        Button btnFindId= (Button) findViewById(R.id.btnFindId);
        Button btnFindPass= (Button) findViewById(R.id.btnFindPass);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //아이디찾기
        btnFindId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent findIdintent = new Intent(FindMyInfo.this, LoginActivity.class);
                FindMyInfo.this.startActivity(findIdintent);
            }
        });
        //비밀번호찾기
        btnFindId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent findPassintent = new Intent(FindMyInfo.this,LoginActivity.class);
                FindMyInfo.this.startActivity(findPassintent);
            }
        });
    }

}
