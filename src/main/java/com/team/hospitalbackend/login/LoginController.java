package com.team.hospitalbackend.login;

import com.team.hospitalbackend.user.dto.UserDTO;
import com.team.hospitalbackend.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "注册用户",notes = "")
    @RequestMapping(path = "/reg",method = {RequestMethod.POST})
    public Map<String,Object> reg(@RequestBody UserDTO userDTO){
        Map<String,Object> map=null;
        try{
            map= userService.register(userDTO);
            return map;
        }catch(Exception e){
            logger.error("注册异常"+e.getMessage());

            map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }
    }
}
