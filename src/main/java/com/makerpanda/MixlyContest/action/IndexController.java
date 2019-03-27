package com.makerpanda.MixlyContest.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(path={"/index"})
    public String index(Model model) {
       // if (TeacherLoginService.teacher!= null) {
            model.addAttribute("Name", 55555555);
            model.addAttribute("ID", 1000000);
        //}
       return "shouye/index";
    }
}
