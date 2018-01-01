package com.team.hospitalbackend.hospital.controller;

import com.team.hospitalbackend.hospital.DTO.HospitalDTO;
import com.team.hospitalbackend.hospital.dao.HospitalDao;
import com.team.hospitalbackend.hospital.model.Hospital;
import com.team.hospitalbackend.hospital.service.HospitalService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by smallfeng on 2017/12/30.
 */

@RestController
@RequestMapping(path = "/hospital",method = {RequestMethod.POST})
public class HospitalController {
    private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

    @Autowired
    HospitalService hospitalService;


    @ApiOperation(value = "添加医院",notes = "")
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public Map<String ,Object> add(@RequestBody HospitalDTO hospitalDTO){
        Map<String,Object> map=null;
        try{
            map=hospitalService.add(hospitalDTO);
            return map;
        }catch (Exception e)
        {
            logger.error("添加医院信息异常"+e.getMessage());
            map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }
    }


    @ApiOperation(value = "查找所有医院",notes = "")
    @RequestMapping(path = "/all",method = RequestMethod.POST)
    public List<Hospital> getAll(){
        return hospitalService.getAll();
    }

    @ApiOperation(value = "搜索医院",notes = "")
    @RequestMapping(path = "/getKV")
    public List<Hospital> getKV(@RequestBody HospitalDTO hospitalDTO){
        return hospitalService.getKV(hospitalDTO);
    }


    @ApiOperation(value = "更新医院信息",notes = "")
    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public Map<String,Object> update(@RequestBody HospitalDTO hospitalDTO){
        Map<String,Object> map=null;
        try{
            map=hospitalService.update(hospitalDTO);
            return map;
        }catch(Exception e) {
            logger.error("更新医院信息异常"+e.getMessage());
            map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }
    }

    @ApiOperation(value = "删除医院信息",notes = "")
    @RequestMapping(path = "/delete",method = RequestMethod.POST)
    public Map<String,Object> delete(@RequestBody HospitalDTO hospitalDTO){
        Map<String,Object> map=null;
        try{
            map=hospitalService.delete(hospitalDTO);
            return map;
        }catch (Exception e)
        {
            logger.error("删除医院信息异常"+e.getMessage());
            map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }
    }


}
