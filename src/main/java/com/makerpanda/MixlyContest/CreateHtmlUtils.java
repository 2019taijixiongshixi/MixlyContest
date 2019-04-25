package com.makerpanda.MixlyContest;

import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.service.projectservice.ProjectDisplayService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class CreateHtmlUtils {
    /**
     * @Title: MakeHtml
     * @Description: 创建html
     * @return void    返回类型
     * @throws
     */
    public static void MakeHtml(Integer projectid, Project project){
        try {
            String filePath = "src/main/resources/static/display/template.html";//模板文件地址
            String disrPath="src/main/resources/static/display";
            FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
            int lenght = fileinputstream.available();
            byte bytes[] = new byte[lenght];
            fileinputstream.read(bytes);
            fileinputstream.close();

            //模板文本替换
            String templateContent = new String(bytes);
            templateContent=TextReplace(templateContent,project);

            //生成静态文件
            String fileame = "project"+projectid+"display" + ".html";
            File dest = new File(new File(disrPath).getAbsolutePath()+ "/" + fileame);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            FileOutputStream fileoutputstream = new FileOutputStream(dest);// 建立文件输出流
            byte tag_bytes[] = templateContent.getBytes();
            fileoutputstream.write(tag_bytes);
            fileoutputstream.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
    private static String TextReplace(String templateContent, Project project){
        int[] form=new int[7];
        int i=0;
        ArrayList<String[]> a=
                ProjectDisplayService.getAllfilePath(project,form);
        templateContent=templateContent.
                replaceAll("###ProjectName###",project.getProjectName());
        templateContent=templateContent.
                replaceAll("###VideoURL###",project.getVideoURL());
        templateContent=templateContent.
                replaceAll("###ProjectTeamName###",project.getProjectTeamName());
        templateContent=templateContent.
                replaceAll("###ProjectDescription###",project.getProjectDescription());
        templateContent=templateContent.
                replaceAll("###CompetitionExperience###",project.getCompetitionExperience());

        for(;i<form.length;i++){
            if(form[i]==1){
                String [] array=a.get(0);
                switch (i){
                    case 0:
                        templateContent=templateContent.
                                replaceAll("###ProjectDisplayMap###","../"+array[0]);
                        break;
                    case 1:
                        templateContent=templateContent.
                                replaceAll("###FlowChart###","../"+array[0]);
                        break;
                    case 2:
                        templateContent=templateContent.
                                replaceAll("###ProjectMindMap###","../"+array[0]);
                        break;
                    case 3:
                        templateContent=templateContent.
                                replaceAll("###HardwareCircuitDiagram###","../"+array[0]);
                        break;
                    case 4:
                        templateContent=templateContent.
                                replaceAll("###CodeModuleDiagram###","../"+array[0]);
                        break;
                    case 5:
                        templateContent=templateContent.
                                replaceAll("###StructureChart###","../"+array[0]);
                        break;
                    case 6:
                        templateContent=templateContent.
                                replaceAll("###DesignDocument###","../"+array[0]);
                        break;
                }
                a.remove(0);
            }
        }
        return templateContent;
    }

}
