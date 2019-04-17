package com.makerpanda.MixlyContest.service.studentservice;

import com.makerpanda.MixlyContest.MD5HashHelper;
import com.makerpanda.MixlyContest.dao.ProjectDAO;
import com.makerpanda.MixlyContest.dao.StudentDAO;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.projectservice.ProjectUpdateService;
import org.springframework.stereotype.Service;

@Service
public class StudentLoginService {
    // 将登陆用户的信息保存供全局使用
    public Student student;
    /**
     * 认证学生是否能够成功登录。
     * @param StudentEmail 用户输入的用户邮箱。
     * @param inputPwd 用户输入的密码。
     * @return 如果用户名不存在则返回3，如果用户输入的密码为空返回2, 用户输入密码有误返回1，认证成功返回0。
     */
    public static int verify(String StudentEmail, String inputPwd,Student loginstudent) {
        StudentDAO studentdao = new StudentDAO();
        Integer studentid=studentdao.getStudentIDByStudentEmail(StudentEmail);
        String password = studentdao.getStudentPassword(studentid);
        String MD5Password= MD5HashHelper.encryptPassword(inputPwd);
        if (password == null) {
            return 3;
        } else if (inputPwd == null) {
            return 2;
        } else if (!MD5Password.equals(password)) {
            return 1;
        } else {
            studentdao.getStudentInfo(studentid,loginstudent);  // 登录成功将用户信息保存
            return 0;
        }
    }

    /**
     * 获取当前用户全部信息。
     * @param studentid 当前用户的ID。
     * @param student 需要传入学生对象。
     */
    public static void getStudentInfo(Student student,Integer studentid) {
        StudentDAO studentdao = new StudentDAO();
        studentdao.getStudentInfo(studentid,student);
    }

    /**
     * 获取当前用户的姓名。
     * @param StudentID 当前用户的ID。
     * @return String类型变量，值为当前用户姓名。
     */
    public static String getName(Integer StudentID) {
        StudentDAO studentdao = new StudentDAO();

        return studentdao.getStudentName(StudentID);
    }

    /**
     * 获取当前用户的ID。
     * @param StudentEmail 当前用户的邮箱。
     * @return Integer类型变量，值为用户ID。
     */
    public static Integer getStudentIDByStudentEmail (String StudentEmail) {
        StudentDAO studentdao = new StudentDAO();

        return studentdao.getStudentIDByStudentEmail(StudentEmail);
    }
}