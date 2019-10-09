//
//  Created by 이민호, 전재준, 배진우 on 18/09/2019.
//  Copyright © 2019 이민호. All rights reserved.
//

package com.example.samplesenti.model;

public class Notice {
    String no;
    String title;
    String notice;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Notice(String no, String title, String notice){
        this.no = no;
        this.title = title;
        this.notice = notice;
    }
}
