package com.makerpanda.MixlyContest.action.studentaction;

import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.projectservice.ProjectUpdateService;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import com.makerpanda.MixlyContest.service.studentservice.StudentUpdateService;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherInfoInquireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentUpdateController {
    @RequestMapping(path={"/zhongxin1"})
    public String zhongxin1(Model model) {
        Teacher teacher= TeacherInfoInquireService.TeacherInfoInquire(StudentLoginService.student.getTeacherID());
        String teachername=teacher.getTeacherName();
        String teachertel=teacher.getTeacherTel();
        model.addAttribute("student", StudentLoginService.student);
        if(StudentLoginService.student.getProjectID()!=0) {
            Project project= ProjectUpdateService.getProjectInfo(
                    StudentLoginService.student.getProjectID());
            model.addAttribute("project",project);
            String Student1=StudentLoginService.getName(project.getStudentID1());
            String Student2=null;
            String Student3=null;
            if(project.getStudentID2()!=0)
                Student2=StudentLoginService.getName(project.getStudentID2());
            if(project.getStudentID3()!=0)
                Student3=StudentLoginService.getName(project.getStudentID3());
            model.addAttribute("Student1", Student1);
            model.addAttribute("Student2", Student2);
            model.addAttribute("Student3", Student3);
        }
        else
            model.addAttribute("project",new Project());
        model.addAttribute("TeacherName",teachername);
        model.addAttribute("TeacherTel",teachertel);
        return "shouye/zhongxin1";}
    @RequestMapping(path = {"/studentpasswordupdate"})
    public String StudentUpdatePassword(@ModelAttribute("student") Student student,
                                        @ModelAttribute("code") String Code,
                                        ModelMap modelMap) {
        int verifyCode;
        String newPassword = student.getStudentPassword();
        String email = student.getStudentEmail();
        if (email == null) {
            verifyCode = 4;
        } else if (newPassword == null) {
            verifyCode = 5;
        } else
            verifyCode = StudentUpdateService.StudentUpdatePassword(Code, newPassword, email);

        switch (verifyCode) {
            default:
                return "redirect:404";
            case 0:  // 修改成功
                return "redirect:login1";
            case 1:  // 验证码错误
                modelMap.addAttribute("codeError", "对不起，您输入的验证码有误");
                return "redirect:getmima";
            case 2://没有这个邮箱
                modelMap.addAttribute("mailError", "该邮箱还未注册，请先注册");
                return "redirect:xzhuce";
            case 3:  //系统错误
                modelMap.addAttribute("systemError", "系统错误");
                return "redirect:getmima";
            case 4:  //邮箱错误
                modelMap.addAttribute("inputError", "邮箱不能为空");
                return "redirect:getmima";
            case 5:  //密码错误
                modelMap.addAttribute("inputError", "新密码不能为空");
                return "redirect:getmima";
        }
    }
    @RequestMapping(value = "/studentinfoupdate", method = RequestMethod.POST)
    public String StudentUpdateInfo(@ModelAttribute("student") Student student,
                                    ModelMap modelMap) {
        boolean verifyCode;

        verifyCode= StudentUpdateService.StudentUpdateInfo(student);

        if(verifyCode)
            modelMap.addAttribute("Success", "修改成功");
        else
            modelMap.addAttribute("Error", "修改失败");


        return "redirect:zhongxin1";
    }
}
