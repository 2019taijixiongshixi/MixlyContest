package com.makerpanda.MixlyContest.service.projectservice;

import com.makerpanda.MixlyContest.dao.ProjectDAO;
import com.makerpanda.MixlyContest.datamodel.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProjectDisplayService {
    public static ArrayList<String []> getAllfilePath(Project project,int[] form){
        ArrayList<String[]> filestoragepaths=new ArrayList<>();
        if(project.getProjectDisplayMap()!=null){
            form[0]=1;
            filestoragepaths.add(ProjectFileService.ProjectFilePath(
                    project.getProjectDisplayMap()));
        }
        if(project.getFlowChart()!=null){
            form[1]=1;
            filestoragepaths.add(ProjectFileService.ProjectFilePath(
                    project.getFlowChart()));
        }
        if(project.getProjectMindMap()!=null){
            form[2]=1;
            filestoragepaths.add(ProjectFileService.ProjectFilePath(
                    project.getProjectMindMap()));
        }
        if(project.getHardwareCircuitDiagram()!=null){
            form[3]=1;
            filestoragepaths.add(ProjectFileService.ProjectFilePath(
                    project.getHardwareCircuitDiagram()));
        }
        if(project.getCodeModuleDiagram()!=null){
            form[4]=1;
            filestoragepaths.add(ProjectFileService.ProjectFilePath(
                    project.getCodeModuleDiagram()));
        }
        if(project.getStructureChart()!=null){
            form[5]=1;
            filestoragepaths.add(ProjectFileService.ProjectFilePath(
                    project.getStructureChart()));
        }
        if(project.getDesignDocument()!=null){
            form[6]=1;
            filestoragepaths.add(ProjectFileService.ProjectFilePath(
                    project.getDesignDocument()));
        }
        return filestoragepaths;
    }
    public static ArrayList displayAllProject(){
        ProjectDAO projectdao=new ProjectDAO();
        return projectdao.getProjects();
    }
}
