package com.team.hospitalbackend.user.service;

import com.team.hospitalbackend.user.dao.UserDAO;
import com.team.hospitalbackend.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getUserList() {
        return userDAO.getUserList();
    }
}
