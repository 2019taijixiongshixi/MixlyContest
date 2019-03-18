package com.makerpanda.MixlyContest.action.teacheraction;

import com.makerpanda.MixlyContest.service.TeacherService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
    @RequestMapping(path={"/index"})
    public String index(Model model) {
        if (TeacherService.teacher!= null) {
            model.addAttribute("TeacherName", TeacherService.teacher.getTeacherName()+"老师");
            model.addAttribute("TeacherID", TeacherService.teacher.getTeacherID());
        }
       return "shouye/index.html";}

}
