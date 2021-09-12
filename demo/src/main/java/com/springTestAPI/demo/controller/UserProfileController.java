package com.springTestAPI.demo.controller;

import com.springTestAPI.demo.model.UserProfile;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //controller로 인식
public class UserProfileController {
    private Map<String, UserProfile> userMap; // model과의 연결

    @PostConstruct
    public void init(){ //초기화. db에 디폴트값 넣기
        userMap=new HashMap<String,UserProfile>();
        userMap.put("1",new UserProfile("1","홍길동","111-1111","서울"));
        userMap.put("2",new UserProfile("2","홍길자","111-2222","부산"));
        userMap.put("3",new UserProfile("3","홍길순","111-3333","광주"));
        userMap.put("4",new UserProfile("4","홍길연","111-4444","대전"));
    }

    @GetMapping("/user")
    public String getUserMain(){
        String message = "이 페이지는 유저 메인입니다.";
        return message;
    }

    @GetMapping("/user/{id}") //path
    public UserProfile getUserProfile(@PathVariable("id")String id){
        //PathVariable :{안에들어있는 이름}을 인식하여 path로 인식
        return userMap.get(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getAllUserProfile(){
        return new ArrayList<UserProfile>(userMap.values()); //values값만 arrayList로 변환해서 출력
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id")String id, @RequestParam("name") String name,@RequestParam("phone")String phone,@RequestParam("address")String address){
        UserProfile userProfile = userMap.get(id);
        userProfile.setName(name);
        userProfile.setPhone(phone);
        userProfile.setAddress(address);
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id")String id, @RequestParam("name") String name,@RequestParam("phone")String phone,@RequestParam("address")String address){
        UserProfile userProfile =new UserProfile(id,name,phone,address);
        userMap.put(id,userProfile);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id")String id){
        userMap.remove(id);
    }
}
