package com.makerpanda.MixlyContest.action.projectaction;

import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.projectservice.ProjectUpdateService;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectUpdateController {
    @RequestMapping(path = {"/xinxi1"})
    public String xinxi1(Model model) {
        if(StudentLoginService.student.getProjectID()!=0) {
            Project project= ProjectUpdateService.getProjectInfo(
                    StudentLoginService.student.getProjectID());
            model.addAttribute("project",project);
        }
        else
            model.addAttribute("project",new Project());
        model.addAttribute("student", StudentLoginService.student);
        return "tijiao/xinxi1";
    }
    @RequestMapping(path = {"/xinxi1submission"})
    public String xinxi1Submission(@ModelAttribute("project") Project project,
                                        ModelMap modelMap) {
        boolean verifyCode;

        verifyCode= ProjectUpdateService.createProject(project);

        if(verifyCode)
            modelMap.addAttribute("Success", "创建项目成功");
        else
            modelMap.addAttribute("Error", "创建项目失败");
        return "redirect:xinxi1";
    }
    @RequestMapping(path = {"/xinxi2"})
    public String xinxi2(Model model) { return "tijiao/xinxi2"; }
    @RequestMapping(path = {"/xinxi3"})
    public String xinxi3(Model model) { return "tijiao/xinxi3"; }
    @RequestMapping(path = {"/xinxi4"})
    public String xinxi4(Model model) { return "tijiao/xinxi4"; }
    @RequestMapping(path = {"/xinxi5"})
    public String xinxi5(Model model) { return "tijiao/xinxi5"; }
    @RequestMapping(path = {"/xinxi6"})
    public String xinxi6(Model model) { return "tijiao/xinxi6"; }

}
