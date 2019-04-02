package com.makerpanda.MixlyContest.service.teacherservice;

import com.makerpanda.MixlyContest.dao.ClassDAO;
import com.makerpanda.MixlyContest.dao.StudentDAO;
import com.makerpanda.MixlyContest.dao.TeacherDAO;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherClassService {
    /**
     * 创建班级操作
     * @param teacher 教师对象。
     * @return 创建成功返回1，否则返回0。
     */
    public static boolean createClass(Teacher teacher){
        ClassDAO classdao = new ClassDAO();
        return classdao.createClass(teacher.getTeacherID());
    }
    /**
     * 查询班级操作
     * @param teacher 教师对象。
     * @return ArrayList学生对象。
     */
    public static ArrayList selectClassStudent(Teacher teacher){
        StudentDAO studentdao=new StudentDAO();

        return studentdao.getStudentInfoByTeacherID(teacher.getTeacherID());
    }
}
