package com.makerpanda.MixlyContest.action.projectaction;

import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.service.projectservice.ProjectUpdateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectUpdateController {
    @RequestMapping(path = {"/xinxi1submission"})
    public String xinxi1Submission(@ModelAttribute("project") Project project,
                                        ModelMap modelMap) {
        boolean verifyCode;

        verifyCode= ProjectUpdateService.createProject(project);

        if(verifyCode) modelMap.addAttribute("Success", "创建作品成功");

        else
            modelMap.addAttribute("Error", "创建作品失败");
        return "redirect:xinxi1";
    }

    @RequestMapping(path = {"/projectUpdateText"})
    public String projectUpdateText(@ModelAttribute("project") Project project,
                                    @ModelAttribute("pagepath")String pagepath,
                                    @ModelAttribute("formname") String formname,
                                    ModelMap modelMap) {
        boolean verifyCode;

        verifyCode= ProjectUpdateService.updateProjectText(formname,project);

        if(verifyCode) modelMap.addAttribute("Success", "修改作品成功");

        else
            modelMap.addAttribute("Error", "修改作品失败");
        return "redirect:"+pagepath;
    }
}
