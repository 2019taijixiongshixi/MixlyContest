package com.makerpanda.MixlyContest.action;

import com.makerpanda.MixlyContest.service.teacherservice.TeacherLoginService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
    @RequestMapping(path={"/index"})
    public String index(Model model) {
        if (TeacherLoginService.teacher!= null) {
            model.addAttribute("Name", TeacherLoginService.teacher.getTeacherName()+"老师");
            model.addAttribute("ID", TeacherLoginService.teacher.getTeacherID());
        }
       return "shouye/index.html";}


}
