//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.model;

public class Menu {

    private String name, no, company_no, price;

    public String getNo() {
        return no;
    }

    public String getCompany_no() {
        return company_no;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setCompany_no(String company_no) {
        this.company_no = company_no;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu(String no, String company_no, String price, String name){
        this.no = no;
        this.company_no = company_no;
        this.price = price;
        this.name = name;
    }


}
