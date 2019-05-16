package com.makerpanda.MixlyContest.action.manageaction;

import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.service.manageservice.ManageScoreService;
import com.makerpanda.MixlyContest.service.projectservice.ProjectUpdateService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManageScoreController {
    @RequestMapping(value="/projectscore", method=RequestMethod.GET)
    @ResponseBody
    //初赛评分
    public Object ProjectScore(@RequestParam(value="projectid") Integer projectid,
                                @RequestParam(value="score") Integer score,
                                Model model){
        int verifycode=ManageScoreService.ProjectScore(projectid,score,
                "Preliminaries");
        if(verifycode==0){
            model.addAttribute("Success","评分成功");
        }else if(verifycode==1){
            model.addAttribute("Error","评分失败");
        }
        else if(verifycode==2){
            model.addAttribute("Error","超过评分次数");
        }
        else if(verifycode==3){
            model.addAttribute("Error","未知错误");
        }
        Project project= new Project();
        ProjectUpdateService.getProjectInfo(project,projectid);
        return JSONObject.fromObject(project);
    }
}
