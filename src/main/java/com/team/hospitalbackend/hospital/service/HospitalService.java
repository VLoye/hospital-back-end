package com.team.hospitalbackend.hospital.service;

import com.team.hospitalbackend.hospital.DTO.HospitalDTO;
import com.team.hospitalbackend.hospital.dao.HospitalDao;
import com.team.hospitalbackend.hospital.model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by smallfeng on 2017/12/31.
 */
@Service
public class HospitalService {

    @Autowired
    HospitalDao hospitalDao;

    //add
    public Map<String,Object> add(HospitalDTO hospitalDTO){
        Map<String ,Object> map=new HashMap<>();

        if(StringUtils.isEmpty(hospitalDTO.getName())){
            map.put("msg","医院名不能为空");
            return map;
        }
        if(StringUtils.isEmpty(hospitalDTO.getAddress())){
            map.put("msg","医院地址不能为空");
            return map;
        }
        if(StringUtils.isEmpty(hospitalDTO.getLevel())){
            map.put("msg","医院等级不能为空");
            return map;
        }
        if(StringUtils.isEmpty(hospitalDTO.getTel())){
            map.put("msg","医院联系电话不能为空");
            return map;
        }

        Hospital hospital=hospitalDao.selectByName(hospitalDTO.getName());
        if(hospital!=null){
            map.put("msg","医院已经被注册");
            return map;
        }

        hospital=new Hospital();
        hospital.setName(hospitalDTO.getName());
        hospital.setAddress(hospitalDTO.getAddress());
        hospital.setTel(hospitalDTO.getTel());
        hospital.setLevel(hospitalDTO.getLevel());
        hospital.setIntroduce(hospitalDTO.getIntroduce());

        hospitalDao.addHospital(hospital);
        map.put("msg","医院信息添加成功");

        return map;
    }

    //getAll
    public List<Hospital> getAll(){
        return hospitalDao.selectAll();
    }

    //getBykev_value
    public List<Hospital> getKV(HospitalDTO hospitalDTO){
        return hospitalDao.selectByKey_value("name",hospitalDTO.getName());
    }


    //delete
    public Map<String,Object> delete(HospitalDTO hospitalDTO){
        Map<String,Object> map=new HashMap<>();
        hospitalDao.deleteHospital(hospitalDTO.getName());
        map.put("msg","删除医院信息成功");
        return map;
    }


    //update
    public Map<String,Object> update(HospitalDTO hospitalDTO){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isEmpty(hospitalDTO.getAddress())){
            map.put("msg","医院地址不能为空");
            return map;
        }
        if(StringUtils.isEmpty(hospitalDTO.getLevel())){
            map.put("msg","医院等级不能为空");
            return map;
        }
        if(StringUtils.isEmpty(hospitalDTO.getTel())) {
            map.put("msg", "医院联系电话不能为空");
            return map;
        }

        Hospital hospital=new Hospital();
        hospital.setName(hospitalDTO.getName());
        hospital.setTel(hospitalDTO.getTel());
        hospital.setLevel(hospitalDTO.getLevel());
        hospital.setAddress(hospitalDTO.getAddress());
        hospital.setIntroduce(hospitalDTO.getIntroduce());
        hospitalDao.updateHospital(hospital);
        map.put("msg","更新医院信息成功");
        return map;
    }



}
