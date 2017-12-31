package com.team.hospitalbackend.user.dao;

import com.team.hospitalbackend.user.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTests {

	@Autowired
	UserDAO userDAO;

	@Test
	public void contextLoads() {

		User user = new User();
		user.setName("linlaz1y");
		user.setPassword("aaaaa");
		user.setCertificateNumber("441522199408110676");
		userDAO.addUser(user);
	}
	@Test
	public void updatePswUser(){
		String name="linlaz1y";
		String password="bbbbb";
		userDAO.updatePswUser(name,password);
	}
}
