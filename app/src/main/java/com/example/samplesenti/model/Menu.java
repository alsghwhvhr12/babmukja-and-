//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.model;

import java.io.Serializable;


public class Menu implements Serializable {

    private String name, no, company_no, price, k_id;

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

    public String getK_id() {
        return k_id;
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

    public void setK_id(String k_id) {
        this.k_id = k_id;
    }

    public Menu(String no,  String k_id, String company_no, String name, String price){
        this.no = no;
        this.company_no = company_no;
        this.k_id = k_id;
        this.name = name;
        this.price = price;
    }


}
