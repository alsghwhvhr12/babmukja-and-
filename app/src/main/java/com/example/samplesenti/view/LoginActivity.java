package com.example.samplesenti.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.samplesenti.R;
import com.example.samplesenti.model.Login_M;
import com.example.samplesenti.model.ServerURL;
import com.example.samplesenti.presenter.LoginPresenter;
import com.example.samplesenti.presenter.SessionCallback;
import com.kakao.auth.AuthType;
import com.kakao.auth.Session;
import com.kakao.usermgmt.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements LoginInterface.View, View.OnClickListener{

    private LoginInterface.Presenter presenter;

    private Context mContext;
    private Button btn_custom_login;
    private LoginButton btn_kakao_login;

    private Button registerBtn;
    private RadioGroup radioGroup;
    private Button kakaoBtn;

    private EditText idEdit;
    private EditText passwordEdit;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = getApplicationContext();


        presenter = new LoginPresenter(LoginActivity.this,getApplicationContext(),this);
        presenter.presenterView();

        btn_custom_login = (Button) findViewById(R.id.btn_custom_login);
        btn_custom_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_kakao_login.performClick();
            }
        });
        btn_kakao_login = (LoginButton) findViewById(R.id.btn_kakao_login);
    }



    @Override
    public void setView() {
        kakaoBtn=(Button)findViewById(R.id.btn_custom_login) ;
        kakaoBtn.setOnClickListener(this);
        registerBtn = (Button)findViewById(R.id.registerBtn);
        idEdit = (EditText)findViewById(R.id.idEdit);
        passwordEdit = (EditText)findViewById(R.id.passwordEdit);
        login = (Button)findViewById(R.id.login);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        registerBtn.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //case R.id.btn_custom_login:
              //  btn_kakao_login.performClick();
          //      Session session = Session.getCurrentSession();
            //    session.addCallback(new SessionCallback());
              //  session.open(AuthType.KAKAO_LOGIN_ALL,LoginActivity.this);
        //        break;

            case R.id.registerBtn:
                final Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.login:
                String id = idEdit.getText().toString();
                String pw = passwordEdit.getText().toString();
                //아이디값 or 이름값 넘겨줄것
                Intent i = new Intent(LoginActivity.this,MainMenuAct.class);
                i.putExtra("id",id);
                //i.putExtra("name",name);
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    public  void onResponse(String response){
                        try {
                            int chk = radioGroup.getCheckedRadioButtonId();
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                if(chk == R.id.radioUser){
                                    String id = jsonObject.getString("id");
                                    String pw = jsonObject.getString("pw");
                                    Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this,MainMenuAct.class);
                                    intent.putExtra("id",id);
                                    intent.putExtra("pw",pw);
                                    Log.d(ServerURL.Tag,"성공");
                                    startActivity(intent);
                                }
                                else if(chk == R.id.radioComp){
                                    String id = jsonObject.getString("id");
                                    String pw = jsonObject.getString("pw");
                                    Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, CompanyMainActivity.class);
                                    intent.putExtra("id",id);
                                    intent.putExtra("pw",pw);
                                    Log.d(ServerURL.Tag,"성공");
                                    startActivity(intent);
                                }
                                else if(chk == R.id.radioAdmin){
                                    String id = jsonObject.getString("id");
                                    String pw = jsonObject.getString("pw");
                                    Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this,AdminMainActivity.class);
                                    intent.putExtra("id",id);
                                    intent.putExtra("pw",pw);
                                    Log.d(ServerURL.Tag,"성공");
                                    startActivity(intent);
                                }
                            }else{
                                Toast.makeText(getApplicationContext(),"실패",Toast.LENGTH_SHORT).show();
                                return ;
                            }
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                //데이터통신
                Login_M login = new Login_M(id,pw,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(login);
                //presenter.Login(id, pw);
                break;
        }

    }
}