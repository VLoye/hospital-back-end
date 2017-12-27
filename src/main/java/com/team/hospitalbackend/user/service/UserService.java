package com.team.hospitalbackend.user.service;

import com.team.hospitalbackend.user.dao.UserDAO;
import com.team.hospitalbackend.user.dto.UserDTO;
import com.team.hospitalbackend.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

import static com.alibaba.druid.util.Utils.md5;

@Service
public class UserService {


    @Autowired
    private UserDAO userDAO;

    public Map<String,Object> register(UserDTO userDTO) {
        Map<String,Object> map = new HashMap<>();

        if(StringUtils.isEmpty(userDTO.getName())){
            map.put("msg","用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(userDTO.getPassword())){
            map.put("msg","密码不能为空");
            return map;
        }

        User user =userDAO.selectByName(userDTO.getName());
        if (user!=null){
            map.put("msg","用户已经被注册");
            return map;
        }

        user = new User();
        user.setName(userDTO.getName());
        user.setSex(userDTO.getSex());
        user.setCertificateType(userDTO.getCertificateType());
        user.setCertificateNumber(userDTO.getCertificateNumber());
        user.setBirthDate(userDTO.getBirthDate());
        user.setAddress(userDTO.getAddress());
        user.setMobile(userDTO.getMobile());
        //增强密码强度
        user.setSalt(UUID.randomUUID().toString().substring(0,10));
        user.setPassword(md5(userDTO.getPassword()+user.getSalt()));
        userDAO.addUser(user);

        return map;
    }
}
