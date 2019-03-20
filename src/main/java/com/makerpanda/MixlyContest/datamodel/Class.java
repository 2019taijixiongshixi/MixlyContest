package com.makerpanda.MixlyContest.datamodel;

import java.io.Serializable;

public class Class implements Serializable {
    private Integer classid;

    private Integer teacherid;

    public Integer getClassID() {
        return classid;
    }

    public void setClassID(Integer classid) { this.classid = classid; }

    public Integer getTeacherID() {
        return teacherid;
    }

    public void setTeacherID(Integer teacherid) { this.teacherid = teacherid; }
}
