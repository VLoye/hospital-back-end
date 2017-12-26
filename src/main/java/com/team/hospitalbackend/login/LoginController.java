package com.team.hospitalbackend.login;

import com.team.hospitalbackend.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by linlazy on 2017/12/26.
 */
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping(path = "/reg",method = {RequestMethod.POST})
    public Map<String,Object> reg(@RequestParam("name") String name,
                                  @RequestParam("sex") int sex,
                                  @RequestParam("certificateType") int certificateType,
                                  @RequestParam("certificateNumber") String certificateNumber,
                                  @RequestParam("birthDate") Date birthDate,
                                  @RequestParam("password") String password,
                                  @RequestParam("address") String address,
                                  @RequestParam("mobile") String mobile){
        try{
            Map<String,Object> map = userService.register(name, sex, certificateType,certificateNumber,birthDate,password,address,mobile);
            return map;
        }catch(Exception e){
            logger.error("注册异常"+e.getMessage());

            Map<String,Object> map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }
    }
}
