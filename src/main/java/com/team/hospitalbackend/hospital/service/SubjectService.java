package com.team.hospitalbackend.hospital.service;

import com.team.hospitalbackend.hospital.DTO.SubjectDTO;
import com.team.hospitalbackend.hospital.dao.SubjectDao;
import com.team.hospitalbackend.hospital.model.Subject;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by VLoye on 2017/12/31.
 */
@Service
public class SubjectService {
    @Autowired
    SubjectDao subjectDao;

    public Map<String ,Object> add(SubjectDTO subjectDTO){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isEmpty(subjectDTO.getName())){
            map.put("msg","专科名不能为空");
            return map;
        }
        if(StringUtils.isEmpty(subjectDTO.getHospitalId())){
            map.put("msg","请选择所属医院");
            return map;
        }

        Subject subject=subjectDao.selectByNameAndHospital_id(subjectDTO.getName(),subjectDTO.getHospitalId());
        if(subject!=null)
        {
            map.put("msg","该专科已经存在");
            return map;
        }

        subject=new Subject();
        subject.setName(subjectDTO.getName());
        subject.setHospitalId(subjectDTO.getHospitalId());
        subject.setIntroduce(subjectDTO.getIntroduce());
        subjectDao.addSubject(subject);
        map.put("msg","添加专科信息成功");
        return map;
    }

    public List<Subject> getAll(){
        return subjectDao.selectAll();
    }


    public List<Subject> getByHospital_id(SubjectDTO subjectDTO){
        return subjectDao.selectByHospital_id(subjectDTO.getHospitalId());
    }


    public Map<String,Object> update(SubjectDTO subjectDTO){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isEmpty(subjectDTO.getName())){
            map.put("msg","专科名不能为空");
            return map;
        }
        if(StringUtils.isEmpty(subjectDTO.getHospitalId())){
            map.put("msg","请选择所属医院");
            return map;
        }

        Subject subject=new Subject();
        subject.setId(subjectDTO.getId());
        subject.setName(subjectDTO.getName());
        subject.setHospitalId(subjectDTO.getHospitalId());
        subject.setIntroduce(subjectDTO.getIntroduce());
        subjectDao.updateSubject(subject);

        map.put("msg","更新专科信息成功");
        return map;
    }

    public Map<String ,Object> delete(SubjectDTO subjectDTO){
        Map<String ,Object> map=new HashMap<>();
        subjectDao.deleteSubject(subjectDTO.getId());
        map.put("msg","删除专科信息成功");
        return map;
    }

}
