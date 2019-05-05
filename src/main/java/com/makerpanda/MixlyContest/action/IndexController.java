package com.makerpanda.MixlyContest.action;

import com.makerpanda.MixlyContest.CreateHtmlUtils;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.projectservice.ProjectDisplayService;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class IndexController {

    @RequestMapping(path={"/index","/"})
    public String index(Model model, HttpServletRequest request) {
        ObjectSend(model,request);
        ArrayList projects= ProjectDisplayService.displayAllProject();
        model.addAttribute("projects",projects);
       return "shouye/index";
    }
    @RequestMapping(path={"/about"})
    public String about(Model model, HttpServletRequest request) {
        ObjectSend(model,request);
        return "shouye/about";
    }
    @RequestMapping(path={"/ziliao"})
    public String ziliao(Model model, HttpServletRequest request) {
        ObjectSend(model,request);
        return "shouye/ziliao";
    }
    @RequestMapping(path={"/chuangke"})
    public String chuangke(Model model, HttpServletRequest request) {
        ObjectSend(model,request);
        return "shouye/chuangke";
    }
    @RequestMapping(path = {"/zuopin"})
    public String zuopin(Model model,HttpServletRequest request) {
        HttpSession session=request.getSession();
        String useridentity="";
        if(null!=session.getAttribute("useridentity"))
            useridentity=session.getAttribute("useridentity").toString();
        if(useridentity.equals("student"))
            return "tijiao/zuopin";
        else
            return  "redirect:";
    }
    private void ObjectSend(Model model, HttpServletRequest request){
        HttpSession session=request.getSession();
        Student student=null;
        Teacher teacher=null;
        Integer userid=0;
        String useridentity=null;
        if(null!=session.getAttribute("userid"))
            userid=Integer.parseInt(session.getAttribute("userid").toString());
        if(null!=session.getAttribute("useridentity"))
            useridentity=session.getAttribute("useridentity").toString();
        if(userid!=0){
            if(useridentity.equals("student")){
                student=new Student();
                StudentLoginService.getStudentInfo(student,userid);
            }
            else if(useridentity.equals("teacher")) {
                teacher=new Teacher();
                TeacherLoginService.getTeacherInfo(teacher, userid);
            }
        }
        model.addAttribute("teacher",teacher);
        model.addAttribute("student",student);
    }
}
