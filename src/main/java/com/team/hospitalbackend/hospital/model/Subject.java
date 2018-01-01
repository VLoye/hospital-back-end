package com.team.hospitalbackend.hospital.model;

/**
 * Created by smallfeng on 2017/12/30.
 */
/*
    专科
 */
public class Subject {
    private long id;
    private String name;
    private long hospitalId;
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

    public long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
