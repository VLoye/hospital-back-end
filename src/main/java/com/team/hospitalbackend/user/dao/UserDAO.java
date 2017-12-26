package com.team.hospitalbackend.user.dao;

import com.team.hospitalbackend.user.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDAO {

    String TABLE_NAME=" user ";
    String INSERT_FIELDS=" realname,salt,password ";
    String SELECT_FIELDS=" id, "+INSERT_FIELDS;

    @Insert({" insert into ",TABLE_NAME," ( ",INSERT_FIELDS,")",
    "values(#{realname},#{salt},#{password})"})
    int addUser(User user);

    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME})
    List<User> selectById(long id);

    List<User> getUserList();
}
