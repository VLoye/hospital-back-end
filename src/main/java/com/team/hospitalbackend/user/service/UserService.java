package com.team.hospitalbackend.user.service;

import com.team.hospitalbackend.user.dao.UserDAO;
import com.team.hospitalbackend.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getUserList() {
        return userDAO.getUserList();
    }
}
