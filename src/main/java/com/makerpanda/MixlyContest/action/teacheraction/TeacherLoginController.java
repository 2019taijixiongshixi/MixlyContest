package com.makerpanda.MixlyContest.action.teacheraction;



import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherLoginController {
    @RequestMapping(path = { "/login2"})
    public String Teacherlogin(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "login/login2";
    }
    @RequestMapping(value = "/teacherlogin", method = RequestMethod.POST)
    public String loginAction(@ModelAttribute("teacher") Teacher teacher, ModelMap modelMap) {
        int verifyCode;
        String teacheremail= teacher.getTeacherEmail();

        if (teacheremail!= null) {
            String password = teacher.getTeacherPassword();
            verifyCode = TeacherLoginService.verify(teacheremail, password);  // 认证用户是否可以登录
        } else {
            verifyCode = 4;
        }

        switch (verifyCode) {
            default:
                return "redirect:404";
            case 0:  // 认证成功
                return "redirect:";
            case 1:  // 密码错误
                modelMap.addAttribute("pwdError", "对不起，您输入的密码有误");
                System.out.println("pwdError1");
                return "redirect:login2";
            case 2:
                modelMap.addAttribute("pwdError", "密码不能为空");
                System.out.println("pwdError2");
            case 3:  // 用户不存在或者系统错误
                modelMap.addAttribute("userError", "不存在该用户");
                System.out.println("userError1");
                return "redirect:login2";
            case 4:
                modelMap.addAttribute("userError", "用户名不能为空");
                System.out.println("userError2");
                return "redirect:login2";
        }
    }
}
