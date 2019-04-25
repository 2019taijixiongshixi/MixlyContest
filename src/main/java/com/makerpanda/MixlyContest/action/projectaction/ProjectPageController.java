package com.makerpanda.MixlyContest.action.projectaction;

import com.makerpanda.MixlyContest.CreateHtmlUtils;
import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.projectservice.ProjectDisplayService;
import com.makerpanda.MixlyContest.service.projectservice.ProjectUpdateService;
import com.makerpanda.MixlyContest.service.studentservice.StudentLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class ProjectPageController {
    @RequestMapping(path = {"/xinxi1"})
    public String xinxi1(Model model, HttpServletRequest request) {
        Project project;
        if((project=ObjectSend(model,request))!=null) {
            String Student1=StudentLoginService.getName(project.getStudentID1());
            String Student2=null;
            String Student3=null;
            if(project.getStudentID2()!=0)
                Student2=StudentLoginService.getName(project.getStudentID2());
            if(project.getStudentID3()!=0)
                Student3=StudentLoginService.getName(project.getStudentID3());
            model.addAttribute("Student1", Student1);
            model.addAttribute("Student2", Student2);
            model.addAttribute("Student3", Student3);
            model.addAttribute("project",project);
        }
        else
            model.addAttribute("project",new Project());
        return "tijiao/xinxi1";
    }
    @RequestMapping(path = {"/xinxi2"})
    public String xinxi2(Model model, HttpServletRequest request) {
        Project project;
        if((project=ObjectSend(model,request))!=null) {
            projectDisplay(project,model);
            return "tijiao/xinxi2";
        }
        else
            return "redirect:xinxi1";
    }

    @RequestMapping(path = {"/xinxi3"})
    public String xinxi3(Model model, HttpServletRequest request) {
        Project project;
        if((project=ObjectSend(model,request))!=null) {
            projectDisplay(project,model);
            return "tijiao/xinxi3";
        }
        else
            return "redirect:xinxi1";
    }
    @RequestMapping(path = {"/xinxi4"})
    public String xinxi4(Model model, HttpServletRequest request) {
        Project project;
        if((project=ObjectSend(model,request))!=null) {
            projectDisplay(project,model);
            return "tijiao/xinxi4";
        }
        else
            return "redirect:xinxi1";
    }
    @RequestMapping(path = {"/xinxi5"})
    public String xinxi5(Model model, HttpServletRequest request) {
        if(ObjectSend(model,request)!=null) {
            return "tijiao/xinxi5";
        }
        else
            return "redirect:xinxi1";
    }
    @RequestMapping(path = {"/xinxi6"})
    public String xinxi6(Model model, HttpServletRequest request) {
        Project project;
        if((project=ObjectSend(model,request))!=null) {
            String Student1=StudentLoginService.getName(project.getStudentID1());
            String Student2=null;
            String Student3=null;
            if(project.getStudentID2()!=0)
                Student2=StudentLoginService.getName(project.getStudentID2());
            if(project.getStudentID3()!=0)
                Student3=StudentLoginService.getName(project.getStudentID3());
            model.addAttribute("Student1", Student1);
            model.addAttribute("Student2", Student2);
            model.addAttribute("Student3", Student3);
            model.addAttribute("project",project);
            projectDisplay(project,model);
            return "tijiao/xinxi6";
        }
        else
            return "redirect:xinxi1";
    }
    private Project ObjectSend(Model model, HttpServletRequest request){
        HttpSession session=request.getSession();
        Integer userid=0;
        Student student=new Student();
        Project project=null;
        if(null!=session.getAttribute("userid"))
            userid=Integer.parseInt(session.getAttribute("userid").toString());
        StudentLoginService.getStudentInfo(student,userid);
        if(student.getProjectID()!=0){
            project=new Project();
            ProjectUpdateService.getProjectInfo(project,student.getProjectID());
            session.setAttribute("projectid",project.getProjectID());
            model.addAttribute("project",project);
        }
        model.addAttribute("student",student);
        return project;

    }

    private static void projectDisplay(Project project, Model model){
        int[] form=new int[7];
        ArrayList<String []>a=ProjectDisplayService.getAllfilePath(project,form);
        int i=0;
        for(;i<form.length;i++){
            if(form[i]==1){
                String [] array=a.get(0);
                switch (i){
                    case 0:
                        model.addAttribute("ProjectDisplayMap",array);
                        break;
                    case 1:
                        model.addAttribute("FlowChart",array);
                        break;
                    case 2:
                        model.addAttribute("ProjectMindMap",array);
                        break;
                    case 3:
                        model.addAttribute("HardwareCircuitDiagram",array);
                        break;
                    case 4:
                        model.addAttribute("CodeModuleDiagram",array);
                        break;
                    case 5:
                        model.addAttribute("StructureChart",array);
                        break;
                    case 6:
                        model.addAttribute("DesignDocument",array);
                        break;
                }
                a.remove(0);
            }
        }
    }
}
