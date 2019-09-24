package com.example.samplesenti.model;

public class Cart implements ICart{

    private int no, user_no, menu_no;

    public void setNo(int no) {
        this.no = no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public void setMenu_no(int menu_no) {
        this.menu_no = menu_no;
    }

    @Override
    public int getNo() {
        return no;
    }

    @Override
    public int getUser_no() {
        return user_no;
    }

    @Override
    public int getMenu_no() {
        return menu_no;
    }
}
