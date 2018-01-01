package com.team.hospitalbackend.hospital.controller;

import com.team.hospitalbackend.hospital.DTO.DepartmentDTO;
import com.team.hospitalbackend.hospital.DTO.SubjectDTO;
import com.team.hospitalbackend.hospital.model.Subject;
import com.team.hospitalbackend.hospital.service.SubjectService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(path = "/subject",method = RequestMethod.POST)
public class SubjectController {
    private static final Logger logger= LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    SubjectService subjectService;

    @ApiOperation(value = "添加专科信息",notes = "")
    @RequestMapping(path = "/add")
    public Map<String ,Object> add(@RequestBody SubjectDTO subjectDTO){
        Map<String,Object> map=null;
        try{
            map=subjectService.add(subjectDTO);
            return map;
        }catch (Exception e){
            logger.error("添加专科信息异常"+e.getMessage());
            map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }
    }

    @ApiOperation(value = "获取所有专科信息",notes = "")
    @RequestMapping(path = "/all")
    public List<Subject> getAll(){
        return subjectService.getAll();
    }

    @ApiOperation(value = "根据hospital_id获取专科信息")
    @RequestMapping(path = "/getsubs")
    public List<Subject> getByHospital_id(@RequestBody SubjectDTO subjectDTO){
        return subjectService.getByHospital_id(subjectDTO);
    }

    @ApiOperation(value = "更新专科信息",notes = "")
    @RequestMapping(path = "/update")
    public Map<String,Object> update(@RequestBody SubjectDTO subjectDTO){
        Map<String,Object> map=null;
        try{
            map=subjectService.update(subjectDTO);
            return map;
        }catch (Exception e){
            logger.error("更新专科信息异常"+e.getMessage());
            map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }
    }


    @ApiOperation(value = "删除专科信息",notes = "根据id删除科室信息")
    @RequestMapping(path = "/delete")
    public Map<String,Object> delete(@RequestBody SubjectDTO subjectDTO){
        Map<String ,Object> map=null;
        try{
            map=subjectService.delete(subjectDTO);
            return map;
        }catch (Exception e)
        {
            logger.error("更新专科信息异常"+e.getMessage());
            map=new HashMap<>();
            map.put("msg","服务器异常");
            return map;
        }

    }

}
