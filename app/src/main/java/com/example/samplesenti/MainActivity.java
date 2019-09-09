package com.example.samplesenti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
