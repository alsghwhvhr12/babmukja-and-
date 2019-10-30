package com.example.samplesenti.model;

import java.io.Serializable;

public class HakVO implements Serializable {
    private String productNo;
    private String productCompany_No;
    private String productName;
    private String productPrice;

    public HakVO(String productNo, String productCompany_No,String productName, String productPrice)
    {
        this.productNo = productNo;
        this.productCompany_No = productCompany_No;
        this.productName =productName;
        this.productPrice = productPrice;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductCompany_No() {
        return productCompany_No;
    }

    public void setProductCompany_No(String productCompany_No) {
        this.productCompany_No = productCompany_No;
    }



    /////////////Get/////////////////
    public String getProductName() {
        return productName;
    }
    public String getProductPrice(){
        return productPrice;
    }



    //////////////////Set/////////////
    public String setProductName(String productName) {
        return this.productName=productName;
    }
    public String setProductPrice(String productPrice){
        return this.productPrice=productPrice;
    }

}
