package com.makerpanda.MixlyContest.action.studentaction;



import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class StudentLoginController {
    @RequestMapping(path = { "/login1"})
    public String Studentlogin(Model model) {
        model.addAttribute("student", new Student());
        return "login/login1";
    }
    @RequestMapping(value = "/studentlogin", method = RequestMethod.POST)
    public String loginAction(@ModelAttribute("student") Student student, ModelMap modelMap,
                              HttpServletRequest request) {
        int verifyCode;
        String studentemail=student.getStudentEmail();
        Student studentlogin=new Student();

        //System.out.println(student.getStudentPassword());
        if (studentemail!= null) {
            String password = student.getStudentPassword();
            verifyCode = StudentLoginService.verify(studentemail, password,studentlogin);  // 认证用户是否可以登录
        } else {
            verifyCode = 4;
        }

        switch (verifyCode) {
            default:
                return "redirect:404";
            case 0:  // 认证成功
                HttpSession session=request.getSession();
                session.setAttribute("userid",studentlogin.getStudentID());
                session.setAttribute("projectid",studentlogin.getProjectID());
                session.setAttribute("useridentity","student");
                return "redirect:index";
            case 1:  // 密码错误
                modelMap.addAttribute("pwdError", "对不起，您输入的密码有误");
                System.out.println("pwdError1");
                return "redirect:login1";
            case 2:
                modelMap.addAttribute("pwdError", "密码不能为空");
                System.out.println("pwdError2");
            case 3:  // 用户不存在或者系统错误
                modelMap.addAttribute("userError", "不存在该用户");
                System.out.println("userError1");
                return "redirect:login1";
            case 4:
                modelMap.addAttribute("userError", "用户名不能为空");
                System.out.println("userError2");
                return "redirect:login1";
        }
    }
}
