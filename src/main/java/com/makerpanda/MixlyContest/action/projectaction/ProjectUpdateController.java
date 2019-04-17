package com.makerpanda.MixlyContest.action.projectaction;

import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.service.projectservice.ProjectUpdateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProjectUpdateController {
    @RequestMapping(path = {"/xinxi1submission"})
    public String xinxi1Submission(@ModelAttribute("project") Project project,
                                   ModelMap modelMap, HttpServletRequest request) {
        boolean verifyCode;
        HttpSession session=request.getSession();
        Integer userid=Integer.parseInt(session.getAttribute("userid").toString());

        verifyCode= ProjectUpdateService.createProject(project,userid);

        if(verifyCode) modelMap.addAttribute("Success", "创建作品成功");

        else
            modelMap.addAttribute("Error", "创建作品失败，请确认信息填写无误!");
        return "redirect:xinxi1";
    }

    @RequestMapping(path = {"/projectUpdateText"})
    public String projectUpdateText(@ModelAttribute("project") Project project,
                                    @ModelAttribute("pagepath")String pagepath,
                                    @ModelAttribute("formname") String formname,
                                    ModelMap modelMap, HttpServletRequest request) {
        boolean verifyCode;
        HttpSession session=request.getSession();
        Integer projectid=0;
        if(null!=session.getAttribute("projectid"))
            projectid=Integer.parseInt(session.getAttribute("projectid").toString());
        verifyCode= ProjectUpdateService.updateProjectText(formname,project,projectid);

        if(verifyCode) modelMap.addAttribute("Success", "修改作品成功");

        else
            modelMap.addAttribute("Error", "修改作品失败");
        return "redirect:"+pagepath;
    }
}
