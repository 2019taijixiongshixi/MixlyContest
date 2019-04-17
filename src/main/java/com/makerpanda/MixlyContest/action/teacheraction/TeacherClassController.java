package com.makerpanda.MixlyContest.action.teacheraction;

import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherClassService;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class TeacherClassController {
    @RequestMapping(path={"/zhongxin2"})
    public String zhongxin2(Model model, HttpServletRequest request) {
        Teacher teacher=ObjectSend(request);
        HttpSession session=request.getSession();
        session.setAttribute("classid",teacher.getTeacherID());
        model.addAttribute("teacher", teacher);
        return "shouye/zhongxin2";
    }

    @RequestMapping(path={"/banji"})
    public String banji(Model model, HttpServletRequest request) {
        Integer userid = null;
        Teacher teacher=ObjectSend(request);
        ArrayList students= TeacherClassService.selectClassStudent(userid);
        model.addAttribute("teacher", teacher);
        if(teacher.getTeacherClassID()==0){
            model.addAttribute("ClassExistence", false);
        }
        else
            model.addAttribute("ClassExistence", true);
        model.addAttribute("students", students);
        return "shouye/banji";
    }
    @RequestMapping(path={"/createClass"})
    public String createClass(Model model, HttpServletRequest request) {
        HttpSession session=request.getSession();
        Integer userid;
        userid=Integer.parseInt(session.getAttribute("userid").toString());
        if(TeacherClassService.createClass(userid))
            model.addAttribute("Success","创建班级成功");
        else
            model.addAttribute("Error","创建班级失败");

        return "redirect:banji";
    }
    private Teacher ObjectSend(HttpServletRequest request){
        HttpSession session=request.getSession();
        Teacher teacher=new Teacher();
        Integer userid;
        userid=Integer.parseInt(session.getAttribute("userid").toString());
        TeacherLoginService.getTeacherInfo(teacher,userid);
        return teacher;
    }
}
