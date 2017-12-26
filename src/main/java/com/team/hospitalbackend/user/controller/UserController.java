package com.team.hospitalbackend.user.controller;

import com.team.hospitalbackend.user.model.User;
import com.team.hospitalbackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public Map<String,Object> listUser(){
     Map<String,Object> map = new HashMap<>();
        List<User> userList=userService.getUserList();
        map.put("users",userList);
     return map;
    }
}
