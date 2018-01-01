package com.team.hospitalbackend.hospital.dao;

import com.team.hospitalbackend.hospital.model.Department;
import com.team.hospitalbackend.hospital.model.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by smallfeng on 2017/12/31.
 */
@Mapper
public interface DepartmentDao {

    String TABLE_NAME=" department ";
    String INSERT_FIELDS=" name,subject_id,introduce";
    String SELECT_FIELDS=" id, "+INSERT_FIELDS;

    @Insert({"insert into ",TABLE_NAME," ( ",INSERT_FIELDS," ) ",
        "value (#{name},#{subjectId},#{introduce})"})
    int addDepartment(Department department);

    /**
     *
     * @param id
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where id = #{id}"})
    Subject selectById(@Param("id")long id);

    /**
     *
     * @param name
     * @param subject_id
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where name = #{name} and subject_id=#{subjectId}"})
    Department selectByNameAndSubject_id(@Param("name")String name,@Param("subjectId")long subjectId);

    /**
     *
     * @param subject_id
     * @return
     */
    @Select({"select ", SELECT_FIELDS ," from ",TABLE_NAME," where subject_id=#{subjectId}"})
    List<Department> selectBySubject_id(@Param("subjectId")long subjectId);

    @Select({"select ", SELECT_FIELDS ," from ",TABLE_NAME," where ${key} like '%${value}%'"})
    List<Department> selectByKey_value(@Param("key")String key,@Param("value")String value);

    /**
     *
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME })
    List<Department> selectAll();

    @Update({"update ",TABLE_NAME," set name=#{name},subject_id=#{subjectId},introduce=#{introduce} where id = #{id}"})
    int updateDepartement(Department department);

    @Delete({"delete from ",TABLE_NAME," where id=#{id}"})
    int deleteDepartment(@Param("id")long id);

}
