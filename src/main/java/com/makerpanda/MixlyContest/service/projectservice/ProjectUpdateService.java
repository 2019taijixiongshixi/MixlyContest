package com.makerpanda.MixlyContest.service.projectservice;

import com.makerpanda.MixlyContest.dao.ProjectDAO;
import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import org.springframework.stereotype.Service;

@Service
public class ProjectUpdateService {
    public static Project project;

    public static Project getProjectInfo(Integer ProjectID){
        ProjectDAO projectdao=new ProjectDAO();
        return projectdao.getProjectInfo(ProjectID);
    }

    public static boolean createProject(Project newProject){
        newProject.setTeacherID(StudentLoginService.student.getTeacherID());
        newProject.setStudentID1(StudentLoginService.student.getStudentID());
        ProjectDAO projectdao=new ProjectDAO();
        if(projectdao.insertNewProject(newProject)) {
            Integer projectid;
            projectid=projectdao.getProjectIDByStudentID1(newProject.getStudentID1());
            StudentLoginService.student.setProjectID(projectid);
            project=newProject;
            project.setProjectID(projectid);
            return true;
        }
        else
            return false;
    }

    public static boolean updateProjectFile(String formname,String paths){
        Project project1;
        ProjectDAO projectdao=new ProjectDAO();
        project1=project.clone();
        switch (formname){
            case "ProjectDisplayMap":
                project1.setProjectDisplayMap(paths);//展示图
                break;
            case "FlowChart":
                project1.setFlowChart(paths);//流程图
                break;
            case "ProjectMindMap":
                project1.setProjectMindMap(paths);//思维导图
                break;
            case "HardwareCircuitDiagram":
                project1.setHardwareCircuitDiagram(paths);//硬件图
                break;
            case "CodeModuleDiagram":
                project1.setCodeModuleDiagram(paths);//代码图
                break;
            case "StructureChart":
                project1.setStructureChart(paths);//结构图
                break;
            case"DesignDocument":
                project1.setDesignDocument(paths);//设计文档
                break;
            default:
                System.out.println(formname+"找不到对应字段");
                break;
        }
        if(projectdao.updateProject(project1)) {
            project=project1;
            return true;
        }
        else
            return false;
    }
    public static boolean updateProjectText(String formname,Project updateProject) {
        Project project1;
        ProjectDAO projectdao=new ProjectDAO();
        project1=project.clone();
        switch (formname){
            case "ProjectDescription":
                project1.setProjectDescription(updateProject.getProjectDescription());//作品描述
                break;
            case "Equipment":
                project1.setEquipment(updateProject.getEquipment());//使用器材
                break;
            case "VideoURL":
                project1.setVideoURL(updateProject.getVideoURL());//视频链接
                break;
            case "CompetitionExperience":
                project1.setCompetitionExperience(updateProject.getCompetitionExperience());//比赛心得
                break;
            default:
                System.out.println(formname+"找不到对应字段");
                break;
        }
        if(projectdao.updateProject(project1)) {
            project=project1;
            return true;
        }
        else
            return false;
    }

}
