package com.springTestAPI.demo.controller;

import com.springTestAPI.demo.model.UserProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
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

    @GetMapping("/user/{id}") //path
    public UserProfile getUserProfile(@PathVariable("id")String id){
        //PathVariable :{안에들어있는 이름}을 인식하여 path로 인식
        return userMap.get(id);
    }

}
