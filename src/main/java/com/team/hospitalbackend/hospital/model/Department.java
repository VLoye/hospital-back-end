package com.team.hospitalbackend.hospital.model;

/**
 * Created by smallfeng on 2017/12/30.
 */
/*
    科室
 */

public class Department {
    private long id;
    private String name;
    private long subjectId;
    private String introduce;

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

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
