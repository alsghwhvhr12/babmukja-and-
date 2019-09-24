package com.example.samplesenti.presenter;

import com.example.samplesenti.model.User;
import com.example.samplesenti.view.ILoginActView;

public class LoginActPresenter implements ILoginActPresenter {

    ILoginActView loginActView;

    public LoginActPresenter(ILoginActView loginActView){
        this.loginActView = loginActView;
    }

    @Override
    public boolean onLogin(String id, String pw) {
        User user = new User();
        user.setId(id);
        user.setPw(pw);
        String Uid = user.getId();
        String Pwd = user.getPw();

        if(Uid.length() > 2 && Pwd.length() > 2){
            loginActView.onLoginResult("로그인 성공");
            return true;
        }
        else {
            loginActView.onLoginResult("로그인 실패");
            return false;
        }
    }

}
