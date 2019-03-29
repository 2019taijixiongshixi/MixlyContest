package com.makerpanda.MixlyContest.action.teacheraction;

import com.makerpanda.MixlyContest.MailUtil;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherRegisterController {
    @RequestMapping(path = { "/jzhuce"})
    public String TeacherRegister(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "zhuce/jzhuce";
    }

    @RequestMapping(value = "/jzhucetijiao", method = RequestMethod.POST)
    public String registerAction(@ModelAttribute("teacher") Teacher teacher,
                                 //@CookieValue("email") String email ,
                                 @ModelAttribute("code")String Code, ModelMap modelMap) {
        // teacher.setTeacherEmail(email);
        int verifyCode;

        verifyCode=TeacherRegisterService.TeacherRegister(teacher,Code);

        switch (verifyCode) {
            default:
                return "shouye/404";
            case 0:  // 注册成功
                return "login/login2";
            case 1:  // 验证码错误
                modelMap.addAttribute("codeError", "对不起，您输入的验证码有误");
                return "zhuce/jzhuce";
            case 2://邮箱已注册
                modelMap.addAttribute("mailError", "邮箱已注册");
                return "zhuce/jzhuce";
            case 3:  //系统错误
                modelMap.addAttribute("systemError", "系统错误");
                return "zhuce/jzhuce";
        }
    }
}
