package com.team.hospitalbackend.user.dao;

import com.team.hospitalbackend.user.model.User;
import org.apache.ibatis.annotations.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Mapper
public interface UserDAO {

    String TABLE_NAME=" user ";
    String INSERT_FIELDS=" name,salt,password,sex,mobile,address,birthDate,certificate_type,certificate_number";
    String SELECT_FIELDS=" id, "+INSERT_FIELDS;

    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where name = #{name} "})
    User selectByName(@Param("name") String name);

    @Insert({"insert into ",TABLE_NAME," ( ",INSERT_FIELDS, " ) ",
    "values (#{name},#{salt},#{password},#{sex},#{mobile},#{address},#{birthDate},#{certificateType},#{certificateNumber})"})
    int addUser(User user);
    //修改密码
    @Update({"update ",TABLE_NAME," set password = #{password} where name = #{name} "})
    int updatePswUser(@Param("name")String name,@Param("password")String password);
}
