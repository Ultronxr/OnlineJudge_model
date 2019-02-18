package com.oj.entity;

public class UserEntity {

    private int id;
    private String school_id;
    private String password;
    private String name;
    private String sex;
    private String grade;
    private int classs;

    public UserEntity() {}

    public UserEntity(String school_id, String password, String name, String sex, String grade, int classs) {
        this.school_id = school_id;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.classs = classs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getClasss() {
        return classs;
    }

    public void setClasss(int classs) {
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", school_id='" + school_id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                ", classs=" + classs +
                '}';
    }
}
