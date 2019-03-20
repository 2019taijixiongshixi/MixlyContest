package com.makerpanda.MixlyContest.action.studentaction;



import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentLoginController {
    @RequestMapping(path = { "/login1"})
    public String Teacherlogin(Model model) {
        model.addAttribute("student", new Student());
        return "login/login1.html";
    }
    @RequestMapping(value = "/login1", method = RequestMethod.POST)
    public String loginAction(@ModelAttribute("student") Student student, ModelMap modelMap) {
        int verifyCode;
        String studentemail;

        if (student.getStudentEmail() != null) {
            studentemail = student.getStudentEmail();
            String password = student.getStudentPassword();
            verifyCode = TeacherLoginService.verify(studentemail, password);  // 认证用户是否可以登录
        } else {
            verifyCode = 4;
        }

        switch (verifyCode) {
            default:
                return "shouye/404.html";
            case 0:  // 认证成功
                return "shouye/index.html";
            case 1:  // 密码错误
                modelMap.addAttribute("pwdError", "对不起，您输入的密码有误");
                return "login/login1.html";
            case 2:
                modelMap.addAttribute("pwdError", "密码不能为空");
            case 3:  // 用户不存在或者系统错误
                modelMap.addAttribute("userError", "不存在该用户");
                return "login/login1.html";
            case 4:
                modelMap.addAttribute("userError", "用户名不能为空");
                return "login/login1.html";
        }
    }
}
