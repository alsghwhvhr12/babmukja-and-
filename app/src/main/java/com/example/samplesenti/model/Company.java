//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.model;

public class Company implements ICompany {

    private int no;
    private String name, tel;

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public int getNo() {
        return no;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTel() {
        return tel;
    }
}
