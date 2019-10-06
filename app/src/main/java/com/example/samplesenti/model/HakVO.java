package com.example.samplesenti.model;

import java.io.Serializable;

public class HakVO implements Serializable {
    private String productName;
    private String productPrice;

    public HakVO(String productName,String productPrice)
    {
        this.productName =productName;
        this.productPrice = productPrice;
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
