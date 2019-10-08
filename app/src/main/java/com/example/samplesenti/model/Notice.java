package com.example.samplesenti.model;

public class Notice {
    String title;
    String notice;

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

    public Notice(String title, String notice){
        this.title = title;
        this.notice = notice;
    }
}
