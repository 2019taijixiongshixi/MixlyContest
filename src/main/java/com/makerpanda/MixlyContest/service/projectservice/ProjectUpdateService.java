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

    /**
     * 表单1的提交,提交时创建项目对象
     * @param newProject 新的项目对象。
     * @return 创建成功返回0，否则返回1
     */
    public static boolean createProject(Project newProject){
        ProjectDAO projectdao=new ProjectDAO();
        newProject.setTeacherID(StudentLoginService.student.getTeacherID());
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
