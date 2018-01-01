package com.team.hospitalbackend.hospital.service;

import com.team.hospitalbackend.hospital.DTO.HospitalDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by smallfeng on 2017/12/31.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalServiceTest {

    @Autowired
    HospitalService hospitalService;

    @Test
    public void add(){
        HospitalDTO hospitalDTO=new HospitalDTO();

        hospitalDTO.setName("市二医院");
        hospitalDTO.setAddress("市区");
        hospitalDTO.setLevel("三级甲等");
        hospitalDTO.setTel("10086");
        hospitalDTO.setIntroduce("test");

        hospitalService.add(hospitalDTO);
    }

    @Test
    public void update(){
        HospitalDTO hospitalDTO=new HospitalDTO();

        hospitalDTO.setName("市二医院");
        hospitalDTO.setAddress("端州区");
        hospitalDTO.setLevel("三级乙等");
        hospitalDTO.setTel("1008611");
        hospitalDTO.setIntroduce("testtest");

        hospitalService.update(hospitalDTO);
    }

    @Test
    public void delete(){
        HospitalDTO hospitalDTO=new HospitalDTO();

        hospitalDTO.setName("11111111");
        hospitalService.delete(hospitalDTO);
    }

}
