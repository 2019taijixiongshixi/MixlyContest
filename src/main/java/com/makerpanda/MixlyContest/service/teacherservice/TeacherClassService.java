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
     * @param teacherid 教师ID。
     * @return 创建成功返回1，否则返回0。
     */
    public static boolean createClass(Integer teacherid){
        ClassDAO classdao = new ClassDAO();
        return classdao.createClass(teacherid);
    }
    /**
     * 查询班级操作
     * @param teacherid 教师ID。
     * @return ArrayList学生对象。
     */
    public static ArrayList selectClassStudent(Integer teacherid){
        StudentDAO studentdao=new StudentDAO();

        return studentdao.getStudentInfoByTeacherID(teacherid);
    }
}
