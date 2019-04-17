package com.makerpanda.MixlyContest.service.teacherservice;

import com.makerpanda.MixlyContest.dao.TeacherDAO;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import org.springframework.stereotype.Service;

@Service
public class TeacherInfoInquireService {
    public static Teacher TeacherInfoInquire(Integer TeacherID){
        TeacherDAO teacherdao=new TeacherDAO();
        Teacher teacher=new Teacher();
        teacherdao.getTeacherInfo(TeacherID,teacher);
        return teacher;
    }
}
