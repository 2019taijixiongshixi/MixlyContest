package com.makerpanda.MixlyContest.datamodel;

import java.io.Serializable;

public class Teacher implements Serializable {
    private Integer teacherid;

    private String teacheridentify;

    private String teachername;

    private String teachergender;

    private String teachercertificationid;

    private String teachertel;

    private String teacheremail;

    private String teacherpassword;

    private Integer classid;

    private String school;

    public Integer getTeacherID() {
        return teacherid;
    }

    public void setTeacherID(Integer teacherid) { this.teacherid = teacherid; }

    public String getTeacherIdentify() {
        return teacheridentify;
    }

    public void setTeacherIdentify(String teacheridentify)
    { this.teacheridentify = teacheridentify; }

    public String getTeacherName() {
        return teachername;
    }

    public void setTeacherName(String teachername) { this.teachername = teachername; }

    public String getTeacherGender() { return teachergender; }

    public void setTeacherGender(String teachergender) { this.teachergender = teachergender; }

    public String getTeacherCertificationID() { return teachercertificationid; }

    public void setTeacherCertificationID(String teachercertificationid)
    { this.teachercertificationid = teachercertificationid; }

    public String getTeacherTel() { return teachertel; }

    public void setTeacherTel(String teachertel) { this.teachertel = teachertel; }

    public String getTeacherEmail(){ return teacheremail; }

    public void setTeacherEmail(String teacheremail) { this.teacheremail = teacheremail; }

    public String getTeacherPassword(){ return teacherpassword; }

    public void setTeacherPassword(String teacherpassword) { this.teacherpassword = teacherpassword; }

    public void setTeacherClassID(Integer classid) { this.classid = classid; }

    public Integer getTeacherClassID() {
        return classid;
    }

    public String getTeacherSchool(){ return school; }

    public void setTeacherSchool(String school) { this.school = school;}

    }
