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

}
