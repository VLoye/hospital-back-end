package com.team.hospitalbackend.hospital.DTO;

import com.team.hospitalbackend.hospital.model.Department;
import com.team.hospitalbackend.hospital.model.Subject;

import java.util.List;

/**
 * Created by smallfeng on 2017/12/31.
 */
public class HospitalDTO {
    private long id;
    private String name;
    private String address;
    private String tel;
    private String level;
    private String introduce;
    private List<Subject> subjects;
    private List<Department> departments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
