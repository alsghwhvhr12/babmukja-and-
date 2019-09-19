package com.example.samplesenti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        EditText etId  = (EditText) findViewById(R.id.etId);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etPhone = (EditText) findViewById(R.id.etPhone);
        Button btnReg= (Button) findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(RegActivity.this,loginAct.class);
                RegActivity.this.startActivity(registerintent);
            }
        });
    }
}
