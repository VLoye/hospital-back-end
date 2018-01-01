package com.team.hospitalbackend.hospital.service;

import com.team.hospitalbackend.hospital.DTO.DepartmentDTO;
import com.team.hospitalbackend.hospital.dao.DepartmentDao;
import com.team.hospitalbackend.hospital.model.Department;
import com.team.hospitalbackend.hospital.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by VLoye on 2017/12/31.
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    public Map<String ,Object> add(DepartmentDTO departmentDTO){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isEmpty(departmentDTO.getName())){
            map.put("msg","科室名不能为空");
            return map;
        }
        if(StringUtils.isEmpty(departmentDTO.getSubjectId())){
            map.put("msg","请选择所属专科");
            return map;
        }

        Department department=departmentDao.selectByNameAndSubject_id(departmentDTO.getName(),departmentDTO.getSubjectId());
        if(department!=null)
        {
            map.put("msg","该科室已经存在");
            return map;
        }

        department=new Department();
        department.setName(departmentDTO.getName());
        department.setSubjectId(departmentDTO.getSubjectId());
        department.setIntroduce(departmentDTO.getIntroduce());
        departmentDao.addDepartment(department);
        map.put("msg","添加科室信息成功");
        return map;
    }

    public List<Department> getBySubject_id(DepartmentDTO departmentDTO){
        return departmentDao.selectBySubject_id(departmentDTO.getSubjectId());
    }

    public List<Department> getKV(DepartmentDTO departmentDTO){
        return departmentDao.selectByKey_value("name",departmentDTO.getName());
    }

    public List<Department> getAll(){
        return departmentDao.selectAll();
    }

    public Map<String,Object> update(DepartmentDTO departmentDTO){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isEmpty(departmentDTO.getName())){
            map.put("msg","科室名不能为空");
            return map;
        }
        if(StringUtils.isEmpty(departmentDTO.getSubjectId())){
            map.put("msg","请选择所属专科");
            return map;
        }

        Department department=new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
        department.setSubjectId(departmentDTO.getSubjectId());
        department.setIntroduce(departmentDTO.getIntroduce());
        departmentDao.updateDepartement(department);
        map.put("msg","更新科室信息成功");
        return map;
    }

    public Map<String ,Object> delete(DepartmentDTO departmentDTO){
        Map<String ,Object> map=new HashMap<>();
        departmentDao.deleteDepartment(departmentDTO.getId());
        map.put("msg","删除科室信息成功");
        return map;
    }

}
