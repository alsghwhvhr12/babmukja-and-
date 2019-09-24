package com.example.samplesenti.model;

public class User implements IUser {

    private int no;
    private String id, pw, name;
    private byte kind;

    public void setNo(int no) {
        this.no = no;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKind(byte kind) {
        this.kind = kind;
    }

    @Override
    public int getNo() {
        return no;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getPw() {
        return pw;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public byte getKind() {
        return kind;
    }
}
