package com.team.hospitalbackend.hospital.dao;

import com.team.hospitalbackend.hospital.model.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by smallfeng on 2017/12/31.
 */
@Mapper
public interface SubjectDao {

    String TABLE_NAME=" subject ";
    String INSERT_FIELDS=" name,hospital_id,introduce";
    String SELECT_FIELDS=" id, "+INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAME," ( ",INSERT_FIELDS," ) ",
        " value (#{name},#{hospitalId},#{introduce})"})
    int addSubject(Subject subject);

    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where id = #{id}"})
    Subject selectById(@Param("id")long id);

    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where name=#{name} and hospital_id=#{hospitalId}"})
    Subject selectByNameAndHospital_id(@Param("name")String name,@Param("hospitalId")long hospitalId);

    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME})
    List<Subject> selectAll();

    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where hospital_id=#{hospitalId}"})
    List<Subject> selectByHospital_id(@Param("hospitalId")long hospitalId);

    @Update({"update ",TABLE_NAME, " set name=#{name},hospital_id=#{hospitalId},introduce=#{introduce} where id=#{id}"})
    int updateSubject(Subject subject);

    @Delete({"delete from ", TABLE_NAME , " where id = #{id}"})
    int deleteSubject(@Param("id")long id);
}
