package com.makerpanda.MixlyContest.action;

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
    @RequestMapping(path = {"/jzhuce"})
    public String jzhuce(Model model) { return "zhuce/jzhuce.html"; }
    @RequestMapping(path = {"/xzhuce"})
    public String xzhuce(Model model) { return "zhuce/xzhuce.html"; }
    @RequestMapping(path = {"/zhuce"})
    public String zhuce(Model model) { return "zhuce/zhuce.html"; }
    @RequestMapping(path={"/login"})
    public String login(Model model) {return "login/login.html";}
    @RequestMapping(path={"/index"})
    public String index(Model model) {return "shouye/index.html";}
    @RequestMapping(path={"/about"})
    public String about(Model model) {return "shouye/about.html";}
    @RequestMapping(path={"/"})
    public String index2(Model model) {return "shouye/index.html";}
    @RequestMapping(path={"/ziliao"})
    public String blog(Model model) {return "shouye/ziliao.html";}
    @RequestMapping(path={"/chuangke"})
    public String contract(Model model) {return "shouye/chuangke.html";}
    @RequestMapping(path={"/account"})
    public String account(Model model) {return "shouye/account.html";}

}
