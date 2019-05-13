package com.makerpanda.MixlyContest.service.manageservice;

import com.makerpanda.MixlyContest.dao.ProjectDAO;
import com.makerpanda.MixlyContest.datamodel.Project;
import com.makerpanda.MixlyContest.service.projectservice.ProjectUpdateService;
import org.springframework.stereotype.Service;

@Service
public class ManageScoreService {
    /**
     * 对分数进行评比,根据表中分数已评比次数来确定分数计算规则
     * 如果次数为0，则直接写入，次数为1，则与新分数相加取平均
     * 次数为2，则乘2作为权重再加上新分数，最后除以三，获取平均数
     * 次数为3，直接返回。
     *
     * @param projectid 项目ID。
     * @param score     评审分数
     * @param scoretype 决定是初赛分数还是决赛分数。
     * @return 修改成功返回0，更新失败返回1，超过次数返回2,其他错误返回3
     */
    public int ProjectScore(Integer projectid, Integer score, String scoretype) {
        Project project = new Project();
        ProjectUpdateService.getProjectInfo(project, projectid);
        int verifycode;

        ProjectDAO projectdao = new ProjectDAO();
        if (scoretype.equals("Preliminaries")) {
            switch (project.getPreliminariesScoreTimes()) {
                case 0:
                    project.setPreliminariesScore(score);
                    break;
                case 1:
                    project.setPreliminariesScore((project.getPreliminariesScore() + score) / 2);
                    break;
                case 2:
                    project.setPreliminariesScore((project.getPreliminariesScore() * 2 + score) / 3);
                    break;
                case 3:
                    verifycode = 2;
                    return verifycode;
                default:
                    verifycode=3;
                    return verifycode;
            }
        } else if (scoretype.equals("Final")) {
            switch (project.getFinalScoreTimes()) {
                case 0:
                    project.setFinalScore(score);
                    break;
                case 1:
                    project.setFinalScore((project.getFinalScore() + score) / 2);
                    break;
                case 2:
                    project.setFinalScore((project.getFinalScore() * 2 + score) / 3);
                    break;
                case 3:
                    verifycode = 2;
                    return verifycode;
                default:
                    verifycode=3;
                    return verifycode;
            }
        }

        if (projectdao.updateProject(project))
            verifycode = 0;
        else
            verifycode = 1;
        return verifycode;
    }
}
