package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.samplesenti.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_go = (Button) findViewById(R.id.moveButton);
        btn_go.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                    //로그인화면
                    Intent intent = new Intent(getApplicationContext(),loginAct.class);
                    //액티비티 시작
                    startActivity(intent);
                    }
                }
        );
    }
}
