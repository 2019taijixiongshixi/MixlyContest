package com.makerpanda.MixlyContest.service.manageservice;

import com.makerpanda.MixlyContest.dao.ProjectDAO;
import com.makerpanda.MixlyContest.dao.StudentDAO;
import com.makerpanda.MixlyContest.dao.TeacherDAO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ManageDisplayService {
    public static ArrayList displayAllProject(){
        ProjectDAO projectdao=new ProjectDAO();
        return projectdao.getProjects();
    }
    public static ArrayList displayCount(){
        StudentDAO studentDAO=new StudentDAO();
        ProjectDAO projectDAO=new ProjectDAO();
        TeacherDAO teacherDAO=new TeacherDAO();
        ArrayList <Integer> count=new ArrayList<>();
        //安装顺序，统计学生数目、教师数目、项目数目、学校数目
        count.add(studentDAO.countStudent());
        count.add(teacherDAO.countTeacher());
        count.add(projectDAO.countProject());
        count.add(studentDAO.countSchool());
        return count;
    }
}
