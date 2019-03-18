package com.makerpanda.MixlyContest.action.teacheraction;



import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.TeacherService;
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
        return "login/login2.html";
    }
    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    public String loginAction(@ModelAttribute("teacher") Teacher teacher, ModelMap modelMap) {
        int verifyCode;
        String teacheremail;

        if (teacher.getTeacherEmail() != null) {
            teacheremail = teacher.getTeacherEmail();
            String password = teacher.getTeacherPassword();
            verifyCode = TeacherService.verify(teacheremail, password);  // 认证用户是否可以登录
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
                return "login/login2.html";
            case 2:
                modelMap.addAttribute("pwdError", "密码不能为空");
            case 3:  // 用户不存在或者系统错误
                modelMap.addAttribute("userError", "不存在该用户");
                return "login/login2.html";
            case 4:
                modelMap.addAttribute("userError", "用户名不能为空");
                return "login/login2.html";
        }
    }
}
