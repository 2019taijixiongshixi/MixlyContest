package com.makerpanda.MixlyContest.action.projectaction;

import com.makerpanda.MixlyContest.service.projectservice.ProjectDeleteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProjectDeleteController {
    @RequestMapping(path = {"/projectdelete"})
    public String xinxi1(ModelMap modelMap,
                         HttpServletRequest request) {
        boolean verifyCode;
        HttpSession session=request.getSession();

        Integer projectid=0;
        if(null!=session.getAttribute("projectid"))
            projectid=Integer.parseInt(session.getAttribute("projectid").toString());

        verifyCode=ProjectDeleteService.deleteProject(projectid);
        if(verifyCode)
            modelMap.addAttribute("Success", "删除项目成功");
        else
            modelMap.addAttribute("Error", "删除项目失败");

        return "redirect:zhongxin1";
    }
}
