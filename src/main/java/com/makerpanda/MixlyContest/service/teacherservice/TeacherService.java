package com.makerpanda.MixlyContest.service.teacherservice;

import com.makerpanda.MixlyContest.MD5HashHelper;
import com.makerpanda.MixlyContest.dao.TeacherDao;
import com.makerpanda.MixlyContest.datamodel.Teacher;

public class TeacherService {
    // 将登陆用户的信息保存供全局使用
    public static Teacher teacher;

    /**
     * 认证教师是否能够成功登录。
     * @param TeacherEmail 用户输入的用户邮箱。
     * @param inputPwd 用户输入的密码。
     * @return 如果用户名不存在则返回3，如果用户输入的密码为空返回2, 用户输入密码有误返回1，认证成功返回0。
     */
    public static int verify(String TeacherEmail, String inputPwd) {
        TeacherDao teacherdao = new TeacherDao();
        String teacherid=teacherdao.getTeacherIDByTeacherEmail(TeacherEmail);
        String password = teacherdao.getTeacherPassword(teacherid);
        String MD5Password= MD5HashHelper.encryptPassword(password);


        if (password == null) {
            return 3;
        } else if (inputPwd == null) {
            return 2;
        } else if (!MD5Password.equals(inputPwd)) {
            return 1;
        } else {
            teacher = teacherdao.getTeacherInfo(teacherid);  // 登录成功将用户信息保存
            return 0;
        }
    }

    /**
     * 获取当前用户的姓名。
     * @param TeacherID 当前用户的ID。
     * @return String类型变量，值为当前用户姓名。
     */
    public static String getName(String TeacherID) {
        TeacherDao teacherdao = new TeacherDao();

        return teacherdao.getTeacherName(TeacherID);
    }

    /**
     * 获取当前用户的ID。
     * @param TeacherEmail 当前用户的ID。
     * @return String类型变量，值为当前用户姓名。
     */
    public static String getTeacherIDByTeacherEmail (String TeacherEmail) {
        TeacherDao teacherdao = new TeacherDao();

        return teacherdao.getTeacherIDByTeacherEmail(TeacherEmail);
    }
}