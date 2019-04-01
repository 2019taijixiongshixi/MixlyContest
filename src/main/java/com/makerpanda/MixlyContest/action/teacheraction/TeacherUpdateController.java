package com.makerpanda.MixlyContest.action.teacheraction;

import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherUpdateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherUpdateController {
    @RequestMapping(path = { "/teacherpasswordupdate"})
    public String TeacherUpdatePassword(@ModelAttribute("teacher")Teacher teacher,
                                        @ModelAttribute("code")String Code,
                                        ModelMap modelMap) {
        int verifyCode;
        String newPassword=teacher.getTeacherPassword();
        String email=teacher.getTeacherEmail();
        if(email==null){
            verifyCode=4;
        }else if(newPassword==null){
            verifyCode=5;
        }
        else
            verifyCode= TeacherUpdateService.TeacherUpdatePassword(Code,newPassword,email);

        switch (verifyCode) {
            default:
                return "shouye/404";
            case 0:  // 修改成功
                return "login/login2";
            case 1:  // 验证码错误
                modelMap.addAttribute("codeError", "对不起，您输入的验证码有误");
                return "login/getmima";
            case 2://没有这个邮箱
                modelMap.addAttribute("mailError", "该邮箱还未注册，请先注册");
                return "zhuce/jzhuce";
            case 3:  //系统错误
                modelMap.addAttribute("systemError", "系统错误");
                return "login/getmima";
            case 4:  //邮箱错误
                modelMap.addAttribute("inputError", "邮箱不能为空");
                return "login/getmima";
            case 5:  //密码错误
                modelMap.addAttribute("inputError", "新密码不能为空");
                return "login/getmima";
        }
    }

    @RequestMapping(value = "/teacherinfoupdate", method = RequestMethod.POST)
    public String TeacherUpdateInfo(@ModelAttribute("teacher") Teacher teacher,
                                    ModelMap modelMap) {
        boolean verifyCode;

        verifyCode= TeacherUpdateService.TeacherUpdateInfo(teacher);

       if(verifyCode)
           modelMap.addAttribute("Success", "修改成功");
       else
           modelMap.addAttribute("Error", "修改失败");
        return "zhuce/jzhuce";
    }

}
