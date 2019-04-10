package com.makerpanda.MixlyContest.service.projectservice;

import com.makerpanda.MixlyContest.datamodel.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProjectFileService {

   public static boolean ProjectFileStorage(String formname, ArrayList filestoragepaths){
       int i=0;
       String paths=new String();
       for(;i<filestoragepaths.size();i++) {
           paths+=filestoragepaths.get(i)+"#";
       }
       return ProjectUpdateService.updateProjectFile(formname,paths);
   }
}
