package com.team.hospitalbackend.user.service;

import com.auth0.jwt.interfaces.Claim;
import com.team.hospitalbackend.user.dao.UserDAO;
import com.team.hospitalbackend.user.dto.UserDTO;
import com.team.hospitalbackend.user.model.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

import static com.alibaba.druid.util.Utils.md5;

@Service
public class UserService {
    private final String secret="Hospital";

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

    public Map<String,Object> login(UserDTO userDTO){
        Map<String,Object> map = new HashMap<>();

        if(StringUtils.isEmpty(userDTO.getName())){
            map.put("msg","用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(userDTO.getPassword())){
            map.put("msg","密码不能为空");
            return map;
        }

        User user=userDAO.selectByName(userDTO.getName());
        if(user==null)
        {
            map.put("msg","用户不存在");
            return map;
        }

        if(user.getPassword().equals(md5(userDTO.getPassword()+user.getSalt()))) {
            //签发token
            String token = Jwts.builder()
                    //主题
                    .setSubject("Subject")
                    //添加参数
                    .claim("name", "VLoye")
                    //设置加密模式+密钥
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
            map.put("token",token);
/*
            //解析token
            try {
                //解析token
                Jws<Claims> p = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
                //获取token主体数据
                Claims body = p.getBody();
                String value = (String) body.get("name");
                System.out.println(value);
            }catch (SignatureException e)
            {
                e.printStackTrace();
            }catch (ExpiredJwtException e)
            {
                e.printStackTrace();
            }

            map.put("msg", "登录成功");
            return map;
        }
*/
        }
        return map;
    }


}
