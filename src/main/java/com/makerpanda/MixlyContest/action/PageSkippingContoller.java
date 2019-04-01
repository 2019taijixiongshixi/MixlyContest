package com.makerpanda.MixlyContest.action;

import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageSkippingContoller {
    @RequestMapping(path = {"/zuopin"})
    public String zuopin(Model model) { return "tijiao/zuopin.html"; }
    @RequestMapping(path = {"/xinxi1"})
    public String xinxi1(Model model) { return "tijiao/xinxi1.html"; }
    @RequestMapping(path = {"/xinxi2"})
    public String xinxi2(Model model) { return "tijiao/xinxi2.html"; }
    @RequestMapping(path = {"/xinxi3"})
    public String xinxi3(Model model) { return "tijiao/xinxi3.html"; }
    @RequestMapping(path = {"/xinxi4"})
    public String xinxi4(Model model) { return "tijiao/xinxi4.html"; }
    @RequestMapping(path = {"/xinxi5"})
    public String xinxi5(Model model) { return "tijiao/xinxi5.html"; }
    @RequestMapping(path = {"/xinxi6"})
    public String xinxi6(Model model) { return "tijiao/xinxi6.html"; }
    @RequestMapping(path = {"/zhuce"})
    public String zhuce(Model model) { return "zhuce/zhuce.html"; }
    @RequestMapping(path={"/login"})
    public String login(Model model) {return "login/login.html";}
    @RequestMapping(path={"/getmima"})
    public String getmima(Model model) {
        model.addAttribute("teacher",new Teacher());
        model.addAttribute("student",new Student());
        return "login/getmima";}
    @RequestMapping(path={"/"})
    public String index2(Model model) {return "shouye/index.html";}
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
    @RequestMapping(path={"/zhongxin1"})
    public String zhongxin1(Model model) {return "shouye/zhongxin1.html";}
    @RequestMapping(path={"/zhongxin2"})
    public String zhongxin2(Model model) {return "shouye/zhongxin2.html";}
    @RequestMapping(path={"/banji"})
    public String banji(Model model) {return "shouye/banji.html";}

}
