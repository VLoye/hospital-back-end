package com.team.hospitalbackend.hospital.dao;

import com.team.hospitalbackend.hospital.model.Hospital;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;

/**
 * Created by smallfeng on 2017/12/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalDaoTest {

   @Autowired
    HospitalDao hospitalDao;

   @Test
   public void addHospital(){
       Hospital hospital=new Hospital();
       hospital.setName("市一医院");
       hospital.setAddress("市中心");
       hospital.setTel("17876253510");
       hospitalDao.addHospital(hospital);
   }
   @Test
   public void selectById(){
       Hospital hospital=new Hospital();
       hospital=hospitalDao.selectByName("市一医院");
    }

    @Test
    public void selectAll(){
        List<Hospital> list;
        list=hospitalDao.selectAll();
    }



}
