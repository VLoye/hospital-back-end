package com.team.hospitalbackend.hospital.dao;

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
public class DepartmentDaoTest {
    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void addDepartment(){
        Department department=new Department();
        department.setName("呼吸222");
        department.setSubjectId(10000);
        departmentDao.addDepartment(department);

    }

    @Test
    public void SelectById(){
        long id=10000;
        departmentDao.selectById(id);

    }

    @Test
    public void selectBySubject_id(){
        long subject_id=10000;
        departmentDao.selectBySubject_id(subject_id);
    }


    @Test
    public void update(){
        Department department=new Department();
        department.setId(10001);
        department.setName("神经科");
        department.setSubjectId(10002);
        departmentDao.updateDepartement(department);
    }

    @Test
    public void delete(){
        long id=10002;
        departmentDao.deleteDepartment(id);
    }

    @Test
    public void selectByKV(){
        Department department=new Department();
        department.setName("呼吸");
        List<Department> list=departmentDao.selectByKey_value("name","呼吸");
        System.out.println(list==null);
        System.out.println(list.size());
        System.out.println(list.get(0).getSubjectId());
    }


}
