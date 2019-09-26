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
