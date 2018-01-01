package com.team.hospitalbackend.hospital.controller;

import com.team.hospitalbackend.hospital.DTO.DepartmentDTO;
import com.team.hospitalbackend.hospital.model.Department;
import com.team.hospitalbackend.hospital.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by smallfeng on 2017/12/31.
 */
@RestController
@RequestMapping(path = "/department",method = RequestMethod.POST)
public class DepartmentController {
    private static final Logger logger= LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService departmentService;

    @ApiOperation(value = "添加科室信息",notes = "")
    @RequestMapping(path = "/add")
    public Map<String ,Object> add(@RequestBody DepartmentDTO departmentDTO){
        Map<String,Object> map=null;
        try{
            map=departmentService.add(departmentDTO);
            return map;
        }catch (Exception e){
            logger.error("添加科室信息异常"+e.getMessage());
            map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }
    }

    @ApiOperation(value = "获取所有科室信息",notes = "")
    @RequestMapping(path = "/all")
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @ApiOperation(value = "搜索医院",notes = "")
    @RequestMapping(path = "/getKV")
    public List<Department> getKV(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.getKV(departmentDTO);
    }

    @ApiOperation(value = "根据subject_id获取科室",notes = "")
    @RequestMapping(path = "/getdepts")
    public List<Department> getdepts(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.getBySubject_id(departmentDTO);
    }

    @ApiOperation(value = "更新科室信息",notes = "")
    @RequestMapping(path = "/update")
    public Map<String,Object> update(@RequestBody DepartmentDTO departmentDTO){
        Map<String,Object> map=null;
        try{
            map=departmentService.update(departmentDTO);
            return map;
        }catch (Exception e){
            logger.error("更新科室信息异常"+e.getMessage());
            map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }
    }


    @ApiOperation(value = "删除科室信息",notes = "根据id删除科室信息")
    @RequestMapping(path = "/delete")
    public Map<String,Object> delete(@RequestBody DepartmentDTO departmentDTO){
        Map<String ,Object> map=null;
        try{
            map=departmentService.delete(departmentDTO);
            return map;
        }catch (Exception e)
        {
            logger.error("更新科室信息异常"+e.getMessage());
            map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }

    }

}
