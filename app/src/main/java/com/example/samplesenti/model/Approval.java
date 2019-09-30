package com.example.samplesenti.model;

public class Approval implements IApproval {

    private int no;
    private byte kind;
    private String price, company_name, menu_name;

    public void setNo(int no) {
        this.no = no;
    }

    public void setKind(byte kind) {
        this.kind = kind;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    @Override
    public int getNo() {
        return no;
    }

    @Override
    public byte getKind() {
        return kind;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public String getCompany_name() {
        return company_name;
    }

    @Override
    public String getMenu_name() {
        return menu_name;
    }
}
