package com.makerpanda.MixlyContest.action.studentaction;

import com.makerpanda.MixlyContest.MailUtil;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.studentservice.StudentRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentRegisterController {
    @RequestMapping(path = { "/xzhuce"})
    public String StudentRegister(Model model) {
        model.addAttribute("student", new Student());
        return "zhuce/xzhuce.html";
    }
    @RequestMapping(value = "/xzhuce", method = RequestMethod.GET)
    public void getVerificationCode(@ModelAttribute("email")String Email){
        MailUtil.getVerificationCode(Email);
    }

    @RequestMapping(value = "/xzhuce", method = RequestMethod.POST)
    public String registerAction(@ModelAttribute("student") Student newstudent,@ModelAttribute("code")String Code, ModelMap modelMap) {
        int verifyCode;

        verifyCode=StudentRegisterService.StudentRegister(newstudent,Code);

        switch (verifyCode) {
            default:
                return "shouye/404.html";
            case 0:  // 注册成功
                return "login/login1.html";
            case 1:  // 验证码错误
                modelMap.addAttribute("codeError", "对不起，您输入的验证码有误");
                return "zhuce/xzhuce.html";
            case 2:// 邮箱已注册
                modelMap.addAttribute("mailError", "邮箱已注册");
                return "zhuce/xzhuce.html";
            case 3:// 班级号错误
                modelMap.addAttribute("classidError","班级号错误" );
                return "zhuce/xzhuce.html";
            case 4:  // 系统错误
                modelMap.addAttribute("systemError", "系统错误");
                return "zhuce/xzhuce.html";
        }
    }
}