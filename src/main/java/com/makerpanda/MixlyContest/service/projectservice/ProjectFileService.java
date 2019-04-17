package com.makerpanda.MixlyContest.service.projectservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProjectFileService {

   public static boolean ProjectFileStorage(String formname, ArrayList filestoragepaths,
                                            Integer projectid){
       int i=0;
       String paths= "";
       for(;i<filestoragepaths.size();i++) {
           paths+=filestoragepaths.get(i)+"#";
       }
       return ProjectUpdateService.updateProjectFile(formname,paths,projectid);
   }
//    public static ArrayList getAllPaths(ArrayList <String>files){
//        int i=0;
//        ArrayList<String[]> allfiles=new ArrayList<>();
//        for(;i<files.size();i++) {
//        allfiles.add(ProjectFilePath(files.get(i)));
//        }
//        return allfiles;
//    }

    public static String[] ProjectFilePath(String pathsstorage){

        return pathsstorage.split("#");
    }

}
