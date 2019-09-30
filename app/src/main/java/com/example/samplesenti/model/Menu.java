//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.model;

public class Menu implements IMenu {

    private int no, company_no, price;
    private String name;

    public void setNo(int no) {
        this.no = no;
    }

    public void setCompany_no(int company_no) {
        this.company_no = company_no;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getNo() {
        return no;
    }

    @Override
    public int getCompany_no() {
        return company_no;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
