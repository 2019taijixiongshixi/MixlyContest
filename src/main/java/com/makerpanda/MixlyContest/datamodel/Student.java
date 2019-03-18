package com.makerpanda.MixlyContest.datamodel;

import java.io.Serializable;

public class Student implements Serializable {
    private String studentid;

    private String projectid;

    private String studentname;

    private String studentgender;

    private String studenttel;

    private String studentemail;

    private String classid;

    private String school;

    private String studentpassword;

    private String teacherid;

    public String getStudentID() { return studentid; }

    public void setStudentID(String studentid) { this.studentid = studentid; }

    public String getProjectID() { return projectid; }

    public void setProjectID(String projectid) { this.projectid = projectid; }

    public String getStudentName() { return studentname; }

    public void setStudentName(String studentname) { this.studentname = studentname; }

    public String getStudentGender() { return studentgender; }

    public void setStudentGender(String studentgender) { this.studentgender = studentgender; }

    public String getStudentTel() { return studenttel; }

    public void setStudentTel(String studenttel) { this.studenttel = studenttel; }

    public String getStudentEmail() { return studentemail; }

    public void setStudentEmail(String studentemail) { this.studentemail = studentemail; }

    public String getClassID() { return classid; }

    public void setClassID(String classid) { this.classid = classid; }

    public String getSchool() { return school; }

    public void setSchool(String school) { this.school = school; }

    public String getStudentPassword() { return studentpassword; }

    public void setStudentPassword(String studentpassword) { this.studentpassword = studentpassword; }

    public String getTeacherID() { return teacherid; }

    public void setTeacherID(String teacherid) { this.teacherid = teacherid; }

}