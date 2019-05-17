package com.makerpanda.MixlyContest.action.manageaction;

import com.makerpanda.MixlyContest.datamodel.Manager;
import com.makerpanda.MixlyContest.service.manageservice.ManageDisplayService;
import com.makerpanda.MixlyContest.service.manageservice.ManageLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ManageDisplayController {
    @RequestMapping(path={"/login5"})
    public String login5(Model model) {
        model.addAttribute("manager",new Manager());
        return "login/login5";}
    @RequestMapping(path={"/login5action"})
    public String login5action(@ModelAttribute("Manager") Manager manager,
                               HttpServletRequest request,Model model) {
        boolean verifyCode= ManageLoginService.verify(manager.getManagerID(),
                manager.getPassword());
        if(verifyCode){
            HttpSession session=request.getSession();
            session.setAttribute("manager",manager.getManagerID());
            return "guanli/guanli1";
        }
        else
            return "redirect:/login5";
    }
    @RequestMapping(path={"guanli1"})
    public String guanli1(Model model,HttpServletRequest request) {
        HttpSession session=request.getSession();
        if(null!=session.getAttribute("manager")) {
            ObjectSend(model);
            return "guanli/guanli1";
        }
        else
            return "redirect:/login5";
    }
    @RequestMapping(path={"guanli2"})
    public String guanli2(Model model,HttpServletRequest request) {
        HttpSession session=request.getSession();
        if(null!=session.getAttribute("manager")) {
            ObjectSend(model);
            return "guanli/guanli2";
        }
        else
            return "redirect:/login5";
    }
    private void ObjectSend(Model model){
        ArrayList projects= ManageDisplayService.displayAllProject();
        ArrayList count=ManageDisplayService.displayCount();
        model.addAttribute("projects",projects);
        model.addAttribute("student_count",count.get(0));
        model.addAttribute("teacher_count",count.get(1));
        model.addAttribute("project_count",count.get(2));
        model.addAttribute("school_count",count.get(3));
    }
}
