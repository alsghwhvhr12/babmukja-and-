package com.example.samplesenti.view;

public class HakVO {
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
