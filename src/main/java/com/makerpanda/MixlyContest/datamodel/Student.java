package com.makerpanda.MixlyContest.datamodel;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer studentid;

    private String studentidentify;

    private Integer projectid;

    private String studentname;

    private String studentgender;

    private String studenttel;

    private String studentemail;

    private Integer classid;

    private String school;

    private String studentpassword;

    private Integer teacherid;

    public Integer getStudentID() { return studentid; }

    public void setStudentID(Integer studentid) { this.studentid = studentid; }

    public String getStudentIdentify() { return studentidentify; }

    public void setStudentIdentify(String studentidentify) { this.studentidentify = studentidentify; }

    public Integer getProjectID() { return projectid; }

    public void setProjectID(Integer projectid) { this.projectid = projectid; }

    public String getStudentName() { return studentname; }

    public void setStudentName(String studentname) { this.studentname = studentname; }

    public String getStudentGender() { return studentgender; }

    public void setStudentGender(String studentgender) { this.studentgender = studentgender; }

    public String getStudentTel() { return studenttel; }

    public void setStudentTel(String studenttel) { this.studenttel = studenttel; }

    public String getStudentEmail() { return studentemail; }

    public void setStudentEmail(String studentemail) { this.studentemail = studentemail; }

    public Integer getClassID() { return classid; }

    public void setClassID(Integer classid) { this.classid = classid; }

    public String getStudentSchool() { return school; }

    public void setStudentSchool(String school) { this.school = school; }

    public String getStudentPassword() { return studentpassword; }

    public void setStudentPassword(String studentpassword) { this.studentpassword = studentpassword; }

    public Integer getTeacherID() { return teacherid; }

    public void setTeacherID(Integer teacherid) { this.teacherid = teacherid; }

}