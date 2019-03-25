package com.makerpanda.MixlyContest.datamodel;

import java.io.Serializable;

public class Project implements Serializable {
    private String projectname;

    private Integer projectid;

    private String flowchart;

    private String projectmindmapping;

    private String codemodulediagram;

    private String videourl;

    private Integer teacherid;

    private Integer studentid1;

    private Integer studentid2;

    private Integer studentid3;

    private String projectteamname;

    private String projectdisplaymap;

    private String projectdescription;

    private String hardwarecircuitdiagram;

    private String srtucturechart;

    private String equipment;

    private String competitionexperience;

    private String designdocument;

    private String preliminariesscore;

    private String finalscore;

    public String getProjectName() { return projectname; }

    public void setProjectName(String projectname) { this.projectname = projectname; }

    public Integer getProjectID() { return projectid; }

    public void setProjectID(Integer projectid) { this.projectid = projectid; }

    public String getFlowChart() { return flowchart; }

    public void setFlowChart(String flowchart) { this.flowchart = flowchart; }

    public String getProjectMindMapping() { return projectmindmapping; }

    public void setProjectMindMapping(String projectmindmapping) { this.projectmindmapping = projectmindmapping; }

    public String getCodeModuleDiagram() { return codemodulediagram; }

    public void setCodeModuleDiagram(String codemodulediagram) { this.codemodulediagram = codemodulediagram; }

    public String getVideoURL() { return videourl; }

    public void setVideoURL(String videourl) { this.videourl = videourl; }

    public Integer getStudentID1() { return studentid1; }

    public void setStudentID1(Integer studentid1) { this.studentid1 = studentid1; }

    public Integer getStudentID2() { return studentid2; }

    public void setStudentID2(Integer studentid2) { this.studentid2 = studentid2; }

    public Integer getStudentID3() { return studentid3; }

    public void setStudentID3(Integer studentid3) { this.studentid3 = studentid3; }

    public String getProjectTeamName() { return projectteamname; }

    public void setProjectTeamName(String projectteamname) { this.projectteamname = projectteamname; }

    public String getProjectDisplayMap() { return projectdisplaymap; }

    public void setProjectDisplayMap(String projectdisplaymap) { this.projectdisplaymap = projectdisplaymap; }

    public String getProjectDescription() { return projectdescription; }

    public void setProjectDescription(String projectdescription) { this.projectdescription = projectdescription; }

    public String getHardwareCircuitDiagram() { return hardwarecircuitdiagram; }

    public void setHardwareCircuitDiagram(String hardwarecircuitdiagram) { this.hardwarecircuitdiagram = hardwarecircuitdiagram; }

    public String getSrtuctureChart() { return srtucturechart; }

    public void setSrtuctureChart(String srtucturechart) { this.srtucturechart = srtucturechart; }

    public String getEquipment() { return equipment; }

    public void setEquipment(String equipment) { this.equipment = equipment; }

    public String getCompetitionExperience() { return competitionexperience; }

    public void setCompetitionExperience(String competitionexperience) { this.competitionexperience = competitionexperience; }

    public String getDesignDocument() { return designdocument; }

    public void setDesignDocument(String designdocument) { this.designdocument = designdocument; }

    public String getPreliminariesScore() { return preliminariesscore; }

    public void setPreliminariesScore(String preliminariesscore) { this.preliminariesscore = preliminariesscore; }

    public String getFinalScore() { return finalscore; }

    public void setFinalScore(String finalscore) { this.finalscore = finalscore; }

    public Integer getTeacherID() { return teacherid; }

    public void setTeacherID(Integer teacherid) { this.teacherid = teacherid; }

}
