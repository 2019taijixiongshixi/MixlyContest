package com.makerpanda.MixlyContest.service.projectservice;

import com.makerpanda.MixlyContest.dao.ProjectDAO;
import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import org.springframework.stereotype.Service;

@Service
public class ProjectUpdateService {

    public static boolean createProject(Project newProject,Integer studentid){
        Student student=null;
        StudentLoginService.getStudentInfo(student,studentid);
        newProject.setTeacherID(student.getTeacherID());
        newProject.setStudentID1(studentid);
        ProjectDAO projectdao=new ProjectDAO();
        return projectdao.insertNewProject(newProject);
    }

    public static boolean updateProjectFile(String formname,
                                            String paths,Integer projectid){
        Project project1=null;
        ProjectDAO projectdao=new ProjectDAO();
        getProjectInfo(project1,projectid);
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
        return projectdao.updateProject(project1);
    }
    public static boolean updateProjectText(String formname,Project updateProject,
                                            Integer projectid) {
        Project project1=null;
        getProjectInfo(project1,projectid);
        ProjectDAO projectdao=new ProjectDAO();
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
        return projectdao.updateProject(project1);
    }

    /**
     * 获取当前用户全部信息。
     * @param projectid 项目ID。
     * @param project 需要传入的项目对象。
     */
    public static void getProjectInfo(Project project ,Integer projectid) {
        ProjectDAO projectdao = new ProjectDAO();
        projectdao.getProjectInfo(projectid,project);
    }
}
