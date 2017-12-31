package com.team.hospitalbackend.user.service;

import com.team.hospitalbackend.user.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
		UserDTO userDTO = new UserDTO();
		userDTO.setName("linlazy");
		userDTO.setPassword("123456");
		userService.register(userDTO);

	}
	@Test
	public void login()
	{
		UserDTO userDTO=new UserDTO();
		userDTO.setName("linlazy");
		userDTO.setPassword("123456");
		userService.login(userDTO);
	}

}
