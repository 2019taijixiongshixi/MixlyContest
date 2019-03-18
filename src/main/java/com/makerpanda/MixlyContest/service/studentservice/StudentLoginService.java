package com.makerpanda.MixlyContest.service.studentservice;

import com.makerpanda.MixlyContest.MD5HashHelper;
import com.makerpanda.MixlyContest.dao.StudentDao;
import com.makerpanda.MixlyContest.datamodel.Student;

public class StudentLoginService {
    // 将登陆用户的信息保存供全局使用
    public static Student student;

    /**
     * 认证学生是否能够成功登录。
     * @param StudentEmail 用户输入的用户邮箱。
     * @param inputPwd 用户输入的密码。
     * @return 如果用户名不存在则返回3，如果用户输入的密码为空返回2, 用户输入密码有误返回1，认证成功返回0。
     */
    public static int verify(String StudentEmail, String inputPwd) {
        StudentDao studentdao = new StudentDao();
        String studentid=studentdao.getStudentIDByStudentEmail(StudentEmail);
        String password = studentdao.getStudentPassword(studentid);
        String MD5Password= MD5HashHelper.encryptPassword(password);

        if (password == null) {
            return 3;
        } else if (inputPwd == null) {
            return 2;
        } else if (!MD5Password.equals(inputPwd)) {
            return 1;
        } else {
            student = studentdao.getStudentInfo(studentid);  // 登录成功将用户信息保存
            return 0;
        }
    }

    /**
     * 获取当前用户的姓名。
     * @param StudentID 当前用户的ID。
     * @return String类型变量，值为当前用户姓名。
     */
    public static String getName(String StudentID) {
        StudentDao studentdao = new StudentDao();

        return studentdao.getStudentName(StudentID);
    }

    /**
     * 获取当前用户的ID。
     * @param StudentEmail 当前用户的ID。
     * @return String类型变量，值为当前用户姓名。
     */
    public static String getStudentIDByStudentEmail (String StudentEmail) {
        StudentDao studentdao = new StudentDao();

        return studentdao.getStudentIDByStudentEmail(StudentEmail);
    }
}