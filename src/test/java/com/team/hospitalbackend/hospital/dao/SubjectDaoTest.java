package com.team.hospitalbackend.hospital.dao;

import com.team.hospitalbackend.hospital.model.Subject;
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
public class SubjectDaoTest {

    @Autowired
    SubjectDao subjectDao;

    @Test
    public void addSubject()
    {
        Subject subject=new Subject();
        subject.setName("神经外科");
        subject.setHospitalId(10000);
        subject.setIntroduce("神经外科");
        subjectDao.addSubject(subject);
    }

    @Test
    public void selectById(){
        long id=10000;
        subjectDao.selectById(id);

    }
}
