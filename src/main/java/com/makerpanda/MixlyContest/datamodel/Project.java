package com.makerpanda.MixlyContest.datamodel;

import java.io.Serializable;

public class Project implements Serializable {
    private String projectname;

    private String projectid;

    private String flowchart;

    private String mindmapping;

    private String codechart;

    private String videolink;

    private String teacherid;

    public String getProjectName() { return projectname; }

    public void setProjectName(String projectname) { this.projectname = projectname; }

    public String getProjectID() { return projectid; }

    public void setProjectID(String projectid) { this.projectid = projectid; }

    public String getFlowChart() { return flowchart; }

    public void setFlowChart(String flowchart) { this.flowchart = flowchart; }

    public String getMindMapping() { return mindmapping; }

    public void setMindMapping(String mindmapping) { this.mindmapping = mindmapping; }

    public String getCodeChart() { return codechart; }

    public void setCodeChart(String codechart) { this.codechart = codechart; }

    public String getVideoLink() { return videolink; }

    public void setVideoLink(String videolink) { this.videolink = videolink; }

    public String getTeacherID() { return teacherid; }

    public void setTeacherID(String teacherid) { this.teacherid = teacherid; }

}
