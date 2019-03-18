package com.makerpanda.MixlyContest.datamodel;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String teacherid;

    private String teachername;

    private String teachersprofessionaltitle;

    private String teachergender;

    private String teachercertificationid;

    private String teachertel;

    private String teacheremail;

    private String teacherpassword;

    public String getTeacherID() {
        return teacherid;
    }

    public void setTeacherID(String teacherid) { this.teacherid = teacherid; }

    public String getTeacherName() {
        return teachername;
    }

    public void setTeacherName(String teachername) { this.teachername = teachername; }

    public String getTeachersProfessionalTitle() {
        return teachersprofessionaltitle;
    }

    public void setTeachersProfessionalTitle(String teachersprofessionaltitle)
    { this.teachersprofessionaltitle = teachersprofessionaltitle; }

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

}
