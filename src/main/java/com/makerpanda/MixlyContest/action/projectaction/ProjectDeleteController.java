package com.makerpanda.MixlyContest.action.projectaction;

import com.makerpanda.MixlyContest.service.projectservice.ProjectDeleteService;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectDeleteController {
    @RequestMapping(path = {"/projectdelete"})
    public String xinxi1(ModelMap modelMap) {
        boolean verifyCode;

        verifyCode=ProjectDeleteService.deleteProject(StudentLoginService.student.getProjectID());
        if(verifyCode)
            modelMap.addAttribute("Success", "删除项目成功");
        else
            modelMap.addAttribute("Error", "删除项目失败");

        return "redirect:zhongxin1";
    }
}
