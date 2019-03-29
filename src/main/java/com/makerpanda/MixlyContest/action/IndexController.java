package com.makerpanda.MixlyContest.action;

import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(path={"/index"})
    public String index(Model model) {
      if (TeacherLoginService.teacher!= null) {
          model.addAttribute("teacher",TeacherLoginService.teacher);
       }
        if (StudentLoginService.student!= null) {
            model.addAttribute("student",StudentLoginService.student);
        }
       return "shouye/index";
    }
}
