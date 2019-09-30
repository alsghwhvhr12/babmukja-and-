//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.model;

public class User implements IUser {

    private int no;
    private String id, pw, name,tel;
    private byte kind;

    public void setNo(int no) {
        this.no = no;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setKind(byte kind) {
        this.kind = kind;
    }

    @Override
    public int getNo() {
        return no;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getPw() {
        return pw;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTel() {
        return tel;
    }

    @Override
    public byte getKind() {
        return kind;
    }
}
