package com.team.hospitalbackend.hospital.dao;

import com.team.hospitalbackend.hospital.model.Hospital;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created by smallfeng on 2017/12/30.
 */
@Mapper
public interface HospitalDao {

    String TABLE_NAME=" hospital ";
    String INSERT_FIELDS=" name,address,tel,level,introduce";
    String SELECT_FIELDS=" id, "+INSERT_FIELDS;

    @Select({"select ", SELECT_FIELDS ," from ",TABLE_NAME," where name = #{name}"})
    Hospital selectByName(@Param("name")String name);

    @Insert({"insert into",TABLE_NAME," ( ", INSERT_FIELDS," ) ",
            " value (#{name},#{address},#{tel},#{level},#{introduce})"})
    int addHospital(Hospital hospital);

    @Select({"select ", SELECT_FIELDS ," from ",TABLE_NAME," where ${key} like '%${value}%' "})
    List<Hospital> selectByKey_value(@Param("key")String key,@Param("value")String value);

    @Delete({"delete from ", TABLE_NAME , " where name = #{name}"})
    int deleteHospital(@Param("name")String name);

    @Select({"select ", SELECT_FIELDS ," from ",TABLE_NAME})
    List<Hospital> selectAll();

    @Update({"update ",TABLE_NAME, " set address=#{address},tel=#{tel},level=#{level},introduce=#{introduce} where name=#{name}"})
    int updateHospital(Hospital hospital);

}
