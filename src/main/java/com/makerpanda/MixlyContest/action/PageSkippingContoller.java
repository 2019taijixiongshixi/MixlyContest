package com.makerpanda.MixlyContest.action;

import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageSkippingContoller {

    @RequestMapping(path = {"/zhuce"})
    public String zhuce(Model model) { return "zhuce/zhuce.html"; }
    @RequestMapping(path={"/login"})
    public String login(Model model) {return "login/login.html";}
    @RequestMapping(path={"/getmima"})
    public String getmima(Model model) {
        model.addAttribute("teacher",new Teacher());
        model.addAttribute("student",new Student());
        return "login/getmima";}
    @RequestMapping(path={"/dashboard"})
    public String dashboard(Model model) {return "master/examples/dashboard.html";}
    @RequestMapping(path={"/icons"})
    public String icons(Model model) {return "master/examples/icons.html";}
    @RequestMapping(path={"/map"})
    public String map(Model model) {return "master/examples/map.html";}
    @RequestMapping(path={"/notifications"})
    public String notifications(Model model) {return "master/examples/notifications.html";}
    @RequestMapping(path={"/tables"})
    public String tables(Model model) {return "master/examples/tables.html";}
    @RequestMapping(path={"/typography"})
    public String typography(Model model) {return "master/examples/typography.html";}
    @RequestMapping(path={"/upgrades"})
    public String upgrades(Model model) {return "master/examples/upgrades.html";}
    @RequestMapping(path={"/user"})
    public String user(Model model) {return "master/examples/user.html";}
    @RequestMapping(path={"/xinxi55"})
    public String xinxi55(Model model) {return "tijiao/xinxi55.html";}
    @RequestMapping(path={"/guanli1"})
    public String guanli1(Model model) {return "guanli/guanli1.html";}
    @RequestMapping(path={"/guanli2"})
    public String guanli2(Model model) {return "guanli/guanli2.html";}

}
