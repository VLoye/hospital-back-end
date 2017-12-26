package com.team.hospitalbackend;

import com.team.hospitalbackend.user.dao.UserDAO;
import com.team.hospitalbackend.user.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/init-schema.sql")
public class InitDatabaseTests {

	@Autowired
	private UserDAO userDAO;

	@Test
	public void contextLoads() {

//		for (int i=0;i<10;i++){
//			User user = new User();
//			user.setSalt("salt");
//			user.setRealname("linlazy");
//			user.setPassword("password");
//			userDAO.addUser(user);
//		}

		List<User> userList = userDAO.selectById(3);
		for(User user:userList){
			System.out.printf(user.toString());
		}

	}

}
