package com.example.samplesenti.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import com.kakao.auth.AccessTokenCallback;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.auth.authorization.accesstoken.AccessToken;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.UserAccount;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoginInterface.View, View.OnClickListener{

    private LoginInterface.Presenter presenter;

    private SessionCallback callback;

    private Context mContext;

    private Button btn_custom_login;
    private LoginButton btn_kakao_login;

    private Button registerBtn;
    private RadioGroup radioGroup;
    private Button kakaoBtn;

    private EditText idEdit;
    private EditText passwordEdit;
    private Button login;


    /////////////////////////카카오 로그인 구현 부분////////////////////////////
    public class SessionCallback implements ISessionCallback {

        // 로그인에 성공한 상태
        @Override
        public void onSessionOpened()  {
            requestMe();
        }

        // 로그인에 실패한 상태
        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            Log.e("SessionCallback :: ", "onSessionOpenFailed : " + exception.getMessage());
        }


        // 사용자 정보 요청
        public void requestMe() {
            List<String> keys = new ArrayList<>();


            // 사용자정보 요청 결과에 대한 Callback
            UserManagement.getInstance().me(keys,new MeV2ResponseCallback() {

                @Override
                public void onSessionClosed(ErrorResult errorResult) {
                   // goMainMenuActivity();
                    Log.e("SessionCallback :: ", "onSessionClosed : " + errorResult.getErrorMessage());
                }


                // 사용자 정보 요청 실패
                @Override
                public void onFailure(ErrorResult errorResult) {
                    Log.e("SessionCallback :: ", "onFailure : " + errorResult.getErrorMessage());
                }

                // 사용자정보 요청에 성공한 경우,
                @Override
                public void onSuccess(MeV2Response response) {
                    Log.d("user id : ",  response.getId()+"");
                    Log.d("email: " , response.getKakaoAccount().getEmail()+"");
                    Log.d("profile image: " , response.getKakaoAccount()+"");

                    long userid = response.getId();
                    String uEmail = response.getKakaoAccount().getEmail();

                    goMainMenuActivity(userid);
                }



                private void goMainMenuActivity(long userid){

                    Intent intent = new Intent(LoginActivity.this, MainMenuAct.class);
                    intent.putExtra("userid",userid);
                    startActivity(intent);
                }

            });
        }
    }


    /////////////////////////카카오 로그인 구현 부분1////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //******************************************//
        mContext = getApplicationContext();
        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);
        Session.getCurrentSession().checkAndImplicitOpen();
        //******************************************//

        presenter = new LoginPresenter(LoginActivity.this,getApplicationContext(),this);
        presenter.presenterView();

        //******************************************//
        btn_custom_login = (Button) findViewById(R.id.btn_custom_login);
        btn_custom_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_kakao_login.performClick();
            }
        });
        btn_kakao_login = (LoginButton) findViewById(R.id.btn_kakao_login);
             //******************************************//

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    @Override
    public void setView() {
        //******************************************//
        kakaoBtn=(Button)findViewById(R.id.btn_custom_login) ;
        kakaoBtn.setOnClickListener(this);

        //******************************************//
        loginBtn = (Button)findViewById(R.id.loginBtn);
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


            case R.id.loginBtn:
                break;
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