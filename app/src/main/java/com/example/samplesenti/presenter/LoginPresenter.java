package com.example.samplesenti.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.samplesenti.model.Login;
import com.example.samplesenti.view.LoginInterface;
import com.example.samplesenti.view.MainActivity;

public class LoginPresenter implements LoginInterface.Presenter {

    private LoginInterface.View view;
    private Context context;
    private Activity activity;
    private Login login;

    public LoginPresenter(LoginInterface.View view, Context context, Activity activity){
        this.view = view;
        this.context = context;
        this.activity = activity;

        login = new Login(context);
    }

    @Override
    public void presenterView() {
        view.setView();
    }

    @Override
    public void Login(String id, String password){
        // Model통해 데이터 통신
        boolean checkLogin = login.checkLogin(id,password);

        // 회원가입 성공
        if(checkLogin){
            login.saveId(id); // id 를 클라이언트에 저장
            login.saveAutoLogin(true); // 자동로그인 저장

            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
            activity.finish();
        }
    }

}
