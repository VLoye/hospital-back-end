package com.team.hospitalbackend.user.service;

import com.team.hospitalbackend.user.dao.UserDAO;
import com.team.hospitalbackend.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;


    public Map<String,Object> register(String name, int sex, int certificateType, String certificateNumber, Date birthDate, String password, String address, String mobile) {
        Map<String,Object> map = new HashMap<>();

        if(StringUtils.isEmpty(name)){
            map.put("msg","用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(password)){
            map.put("msg","密码不能为空");
            return map;
        }

        User user =userDAO.selectByName(name);
        if (user==null){
            map.put("msg","用户已经被注册");
            return map;
        }
        return map;
    }
}
