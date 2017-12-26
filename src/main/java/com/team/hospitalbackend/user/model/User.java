package com.team.hospitalbackend.user.model;

public class User {
    private long id;
    private String realname;
    private String salt;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
