package com.makerpanda.MixlyContest.action.projectaction;

import com.makerpanda.MixlyContest.service.projectservice.ProjectFileService;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectUploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectUploadController.class);

//    @PostMapping("/upload")
//    public String upload(@RequestParam("file") MultipartFile file,
//                         @ModelAttribute("pagepath")String pagepath,
//                         @ModelAttribute("formname") String formname,
//                         ModelMap modelMap) {
//
//        if (file.isEmpty()) {
//            modelMap.addAttribute("Error", "未选择文件");
//            return "redirect:"+pagepath;
//        }
//
//        String fileName = file.getOriginalFilename();
//        String filepath = "upload"+ StudentLoginService.student.getStudentID() +"/"+formname+"/";
//        File dest = new File(new File(filepath).getAbsolutePath()+ "/" + fileName);
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(dest);
//            modelMap.addAttribute("Success", "上传文件成功");
//            return "redirect:"+pagepath;
//        } catch (IOException e) {
//            LOGGER.error(e.toString(), e);
//        }
//        modelMap.addAttribute("Error", "文件过大");
//        return "redirect:"+pagepath;
//    }

    @PostMapping("/multiUpload")
    public String multiUpload(HttpServletRequest request,
                              @ModelAttribute("pagepath")String pagepath,
                              @ModelAttribute("formname") String formname,
                              ModelMap modelMap) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        HttpSession session=request.getSession();
        Integer userid=0;
        Integer projectid;
        if(null!=session.getAttribute("userid"))
            userid=Integer.parseInt(session.getAttribute("userid").toString());
        if(null!=session.getAttribute("projectid")) {
            projectid = Integer.parseInt(session.getAttribute("projectid").toString());
            String filepath = "upload/" + userid + "/" + formname + "/";
            ArrayList<String> filestoragepaths = new ArrayList<>();
            int i = 0;
            for (; i < files.size(); i++) {
                MultipartFile file = files.get(i);
                if (file.isEmpty()) {
                    modelMap.addAttribute("Error", "未选择文件!请选择需要提交的设计图片!");
                    continue;
                }
                //String fileName = file.getOriginalFilename();
                String fileName = formname + i;
                if(formname.equals("DesignDocument"))
                    fileName+=".pdf";
                else
                    fileName+= ".png";
                File dest = new File(new File(filepath).getAbsolutePath() + "/" + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                    String filestoragepath = filepath + fileName;
                    filestoragepaths.add(filestoragepath);
                } catch (IOException e) {
                    LOGGER.error(e.toString(), e);
                    modelMap.addAttribute("Error", "文件过大!请按要求调整图片大小!");
                    return "redirect:" + pagepath;
                }
            }
            if (ProjectFileService.ProjectFileStorage(formname, filestoragepaths, projectid))
                modelMap.addAttribute("Success", "上传文件成功");
            else
                modelMap.addAttribute("Error", "系统错误");
        }
        return "redirect:"+pagepath;
    }
}