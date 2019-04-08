package com.makerpanda.MixlyContest.service.projectservice;

import com.makerpanda.MixlyContest.dao.ProjectDAO;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import org.springframework.stereotype.Service;

@Service
public class ProjectDeleteService {
    public static boolean deleteProject(Integer ProjectID) {
        ProjectDAO projectdao=new ProjectDAO();
        if(projectdao.deleteProject(ProjectID)){
            StudentLoginService.student.setProjectID(0);
            ProjectUpdateService.project=null;
            return true;
        }
        else
            return false;
    }
}
