package com.example.samplesenti.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.samplesenti.FindMyInfo;
import com.example.samplesenti.R;
import com.example.samplesenti.RegActivity;
import com.example.samplesenti.presenter.ILoginActPresenter;
import com.example.samplesenti.presenter.LoginActPresenter;

public class loginAct extends AppCompatActivity implements ILoginActView {

    EditText etId, etPassword;
    Button btnReg, btn_go, btnFind;

    ILoginActPresenter loginActPresenter;
    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etId  = (EditText) findViewById(R.id.etId);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnReg= (Button) findViewById(R.id.btnReg);
        btn_go = (Button) findViewById(R.id.btnLogin);
        btnFind = (Button) findViewById(R.id.btnFind) ;
        loginActPresenter = new LoginActPresenter(this);

        btn_go.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean chk = loginActPresenter.onLogin(etId.getText().toString(), etPassword.getText().toString());

                        if(chk) {
                            //로그인화면
                            Intent intent = new Intent(getApplicationContext(), MainMenuAct.class);
                            //액티비티 시작
                            startActivity(intent);
                        }
                    }
                });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2 = new Intent(loginAct.this, RegActivity.class);
                loginAct.this.startActivity(intent2);
            }
        });

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2 = new Intent(loginAct.this, FindMyInfo.class);
                loginAct.this.startActivity(intent2);
            }
        });

    }


    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
