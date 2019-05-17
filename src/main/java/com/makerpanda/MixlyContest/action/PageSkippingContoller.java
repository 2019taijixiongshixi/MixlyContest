package com.makerpanda.MixlyContest.action;

import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageSkippingContoller {

    @RequestMapping(path = {"/zhuce"})
    public String zhuce(Model model) { return "zhuce/zhuce"; }
    @RequestMapping(path={"/login"})
    public String login(Model model) {return "login/login";}
    @RequestMapping(path={"/login5"})
    public String login5(Model model) {
        model.addAttribute("student",new Student());
        return "login/login5";}
    @RequestMapping(path={"/getmima"})
    public String getmima(Model model) {
        model.addAttribute("teacher",new Teacher());
        model.addAttribute("student",new Student());
        return "login/getmima";
    }
}
