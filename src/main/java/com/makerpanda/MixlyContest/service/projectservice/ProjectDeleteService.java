package com.makerpanda.MixlyContest.service.projectservice;

import com.makerpanda.MixlyContest.dao.ProjectDAO;
import org.springframework.stereotype.Service;

@Service
public class ProjectDeleteService {
    public static boolean deleteProject(Integer ProjectID) {
        ProjectDAO projectdao=new ProjectDAO();
        return projectdao.deleteProject(ProjectID);
    }
}
