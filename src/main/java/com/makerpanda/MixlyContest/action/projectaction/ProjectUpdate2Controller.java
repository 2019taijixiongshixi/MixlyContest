package com.makerpanda.MixlyContest.action.projectaction;

import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.service.projectservice.ProjectUpdateService;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectUpdate2Controller {
    @RequestMapping(path = {"/xinxi2"})
    public String xinxi2(Model model) {
        Project project=ProjectUpdateService.project;
        if(project!=null) {
            model.addAttribute("project",project);
            model.addAttribute("student", StudentLoginService.student);
            return "tijiao/xinxi2";
        }
        else {
            model.addAttribute("project", new Project());
            model.addAttribute("student", StudentLoginService.student);
            return "tijiao/xinxi1";
        }
    }

}
