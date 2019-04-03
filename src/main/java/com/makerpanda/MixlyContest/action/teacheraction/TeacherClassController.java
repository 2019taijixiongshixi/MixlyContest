package com.makerpanda.MixlyContest.action.teacheraction;

import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherClassService;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class TeacherClassController {
    @RequestMapping(path={"/zhongxin2"})
    public String zhongxin2(Model model) {
        model.addAttribute("teacher", TeacherLoginService.teacher);
        return "shouye/zhongxin2";
    }

    @RequestMapping(path={"/banji"})
    public String banji(Model model,@ModelAttribute("teacher") Teacher teacher) {
        ArrayList students= TeacherClassService.selectClassStudent(teacher);
        model.addAttribute("teacher", TeacherLoginService.teacher);
        model.addAttribute("students", students);
        return "shouye/banji";
    }
    @RequestMapping(path={"/createClass"})
    public String createClass(Model model,@ModelAttribute("teacher") Teacher teacher) {
        if(TeacherClassService.createClass(teacher))
            model.addAttribute("Success","创建班级成功");
        else
            model.addAttribute("Error","创建班级失败");

        return "redirect:banji";
    }


}
