package com.example.samplesenti.presenter;

import com.example.samplesenti.model.User;
import com.example.samplesenti.view.IRegActView;

public class RegActPresenter implements IRegActPresenter{
    IRegActView RegActView;

    public RegActPresenter(IRegActView RegActView){
        this.RegActView = RegActView;
    }

    @Override
    public boolean onReg(String id, String pw,String name,String tel) {
        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setName(name);
        user.setTel(tel);
        String Uid = user.getId();
        String Upw = user.getPw();
        String Uname=user.getName();
        String Utel=user.getTel();



        if(Uid.length()<1){
            RegActView.onRegResult("이메일을 입력해주세요.");
            return false;
        }
        else if(Upw.length()<1) {
            RegActView.onRegResult("비밀번호는 4자 이상");
            return false;
        }
        else if(Uname.length()<1) {
            RegActView.onRegResult("이름을 입력해주세요.");
            return false;
        }
        else if(Utel.length()<1) {
            RegActView.onRegResult("전화번호를 입력해주세요.");
            return false;
        }
        else{
            return true;
        }
    }
}
