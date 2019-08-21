package com.jd.springboot.model;

/**
 * @Author: yangfei100
 * @Date: 2019/8/21
 * @Description:
 */
public class User {

    private int id;
    private String nick;
    private String phone;
    private String address;

    public User() {}

    public User(int id, String nick, String phone, String address) {
        this.id = id;
        this.nick = nick;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
