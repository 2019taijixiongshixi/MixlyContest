package com.makerpanda.MixlyContest.action.studentaction;

import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.studentservice.StudentUpdateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentUpdateController {
    @RequestMapping(path = {"/studentpasswordupdate"})
    public String StudentUpdatePassword(@ModelAttribute("teacher") Student student,
                                        @ModelAttribute("code") String Code,
                                        ModelMap modelMap) {
        int verifyCode;
        String newPassword = student.getStudentEmail();
        String email = student.getStudentEmail();
        if (email == null) {
            verifyCode = 4;
        } else if (newPassword == null) {
            verifyCode = 5;
        } else
            verifyCode = StudentUpdateService.StudentUpdatePassword(Code, newPassword, email);

        switch (verifyCode) {
            default:
                return "shouye/404";
            case 0:  // 注册成功
                return "login/login1";
            case 1:  // 验证码错误
                modelMap.addAttribute("codeError", "对不起，您输入的验证码有误");
                return "zhuce/xzhuce";
            case 2:// 邮箱已注册
                modelMap.addAttribute("mailError", "邮箱已注册");
                return "zhuce/xzhuce";
            case 3:// 班级号错误
                modelMap.addAttribute("classidError", "班级号错误");
                return "zhuce/xzhuce";
            case 4:  // 系统错误
                modelMap.addAttribute("systemError", "系统错误");
                return "zhuce/xzhuce";
            case 5:  //密码错误
                modelMap.addAttribute("inputError", "新密码不能为空");
                return "login/getmima";
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
        return "zhuce/xzhuce";
    }
}
