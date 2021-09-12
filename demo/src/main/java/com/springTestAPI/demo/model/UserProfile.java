package com.springTestAPI.demo.model;

public class UserProfile {
    //id,name,phone,address
    private String id; //and,ios에서는 public 으로 멤버 변수를 설정.
    private String name; //서버에서는 private으로 멤버 변수를 설정하는 것이 일반적.
    private String phone;
    private String address;

    //constructor
    public UserProfile(String id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
