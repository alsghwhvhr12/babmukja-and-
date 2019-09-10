package com.example.samplesenti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class loginAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_go = (Button) findViewById(R.id.button);
        btn_go.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v) {
                        //로그인화면
                        Intent intent = new Intent(getApplicationContext(),MainMenuAct.class);
                        //액티비티 시작
                        startActivity(intent);
                    }
                }
        );
    }
}
