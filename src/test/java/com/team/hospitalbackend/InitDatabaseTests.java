package com.team.hospitalbackend;

import com.team.hospitalbackend.user.dao.UserDAO;
import com.team.hospitalbackend.user.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/hospital-schema.sql")
public class InitDatabaseTests {

	@Autowired
	private UserDAO userDAO;

	@Test
	public void contextLoads() {

		User user = userDAO.findByName("linlazy");
		Assert.assertEquals(1,user.getSex());
	}

}
