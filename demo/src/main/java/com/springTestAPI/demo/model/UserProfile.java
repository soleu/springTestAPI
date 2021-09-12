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


}
