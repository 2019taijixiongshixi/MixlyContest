package com.makerpanda.MixlyContest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreateHtmlUtils {
    /**
     * @Title: MakeHtml
     * @Description: 创建html
     * @return void    返回类型
     * @throws
     */
    public static void MakeHtml(Integer userid){
        try {
            String filePath = "src/main/resources/static/display/template.html";//模板文件地址
            String imagePath ="http://localhost/upload/20486/FlowChart/FlowChart0.png";
            String title = "<image src="+'"'+imagePath+'"'+"/>";
            String disrPath="display";
            System.out.print(filePath);
            String templateContent = "";
            FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
            int lenght = fileinputstream.available();
            byte bytes[] = new byte[lenght];
            fileinputstream.read(bytes);
            fileinputstream.close();
            templateContent = new String(bytes);
            templateContent = templateContent.replaceAll("###title###", title);

            String fileame = userid+"-display" + ".html";

            File dest = new File(new File(disrPath).getAbsolutePath()+ "/" + fileame);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            FileOutputStream fileoutputstream = new FileOutputStream(dest);// 建立文件输出流
            System.out.print("文件输出路径:");
            System.out.print(dest);
            byte tag_bytes[] = templateContent.getBytes();
            fileoutputstream.write(tag_bytes);
            fileoutputstream.close();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
}
