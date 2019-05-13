package com.makerpanda.MixlyContest.action.manageaction;

import com.makerpanda.MixlyContest.service.manageservice.ManageDisplayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class ManageDisplayController {
    @RequestMapping(path={"guanli1"})
    public String guanli1(Model model) {
        ObjectSend(model);
        return "guanli/guanli1";}
    @RequestMapping(path={"guanli2"})
    public String guanli2(Model model) {
        ObjectSend(model);
        return "guanli/guanli2";
    }
    private void ObjectSend(Model model){
        ArrayList projects= ManageDisplayService.displayAllProject();
        ArrayList count=ManageDisplayService.displayCount();
        model.addAttribute("projects",projects);
        model.addAttribute("student_count",count.get(0));
        model.addAttribute("teacher_count",count.get(1));
        model.addAttribute("project_count",count.get(2));
        model.addAttribute("school_count",count.get(3));
    }
}
