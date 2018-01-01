package com.team.hospitalbackend.hospital.service;

import com.team.hospitalbackend.hospital.DTO.DepartmentDTO;
import com.team.hospitalbackend.hospital.model.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by smallfeng on 2017/12/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;

    @Test
    public void add(){
        DepartmentDTO departmentDTO=new DepartmentDTO();
        departmentDTO.setName("血液科");
        departmentDTO.setSubjectId(10000);
        departmentDTO.setIntroduce("test");

        departmentService.add(departmentDTO);

    }

    @Test
    public void getAll(){
        List<Department> list=departmentService.getAll();
    }

    @Test
    public void update(){
        DepartmentDTO departmentDTO=new DepartmentDTO();
        departmentDTO.setId(10001);
        departmentDTO.setName("呼吸科");
        departmentDTO.setSubjectId(10000);
        departmentDTO.setIntroduce("serviceTest");
        departmentService.update(departmentDTO);
    }

    @Test
    public void delete(){
        DepartmentDTO departmentDTO=new DepartmentDTO();
        departmentDTO.setId(10003);
        departmentService.delete(departmentDTO);
    }


}
