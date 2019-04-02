package com.makerpanda.MixlyContest.action.teacheraction;

import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class TeacherClassController {
    @RequestMapping(path={"/zhongxin2"})
    public String zhongxin2(Model model) {
        model.addAttribute("teacher",new Teacher());
        return "shouye/zhongxin2";
    }

    @RequestMapping(path={"/banji"})
    public String banji(Model model,@ModelAttribute("teacher") Teacher teacher) {
        ArrayList students= TeacherClassService.selectClassStudent(teacher);
        model.addAttribute("students", students);
        return "shouye/banji";
    }
    @RequestMapping(path={"/createClass"})
    public String createClass(Model model,@ModelAttribute("teacher") Teacher teacher) {
        return "shouye/banji";
    }


}
