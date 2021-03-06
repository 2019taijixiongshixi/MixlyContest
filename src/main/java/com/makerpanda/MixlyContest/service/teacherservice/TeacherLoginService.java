package com.makerpanda.MixlyContest.service.teacherservice;

import com.makerpanda.MixlyContest.MD5HashHelper;
import com.makerpanda.MixlyContest.dao.TeacherDAO;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import org.springframework.stereotype.Service;

@Service
public class TeacherLoginService {

    /**
     * 认证教师是否能够成功登录。
     * @param TeacherEmail 用户输入的用户邮箱。
     * @param inputPwd 用户输入的密码。
     * @return 如果用户名不存在则返回3，如果用户输入的密码为空返回2, 用户输入密码有误返回1，认证成功返回0。
     */
    public static int verify(String TeacherEmail, String inputPwd,Teacher loginteacher) {
        TeacherDAO teacherdao = new TeacherDAO();
        Integer teacherid=teacherdao.getTeacherIDByTeacherEmail(TeacherEmail);
        String password = teacherdao.getTeacherPassword(teacherid);
        String MD5Password= MD5HashHelper.encryptPassword(inputPwd);


        if (password == null) {
            return 3;
        } else if (inputPwd == null) {
            return 2;
        } else if (!MD5Password.equals(password)) {
            return 1;
        } else {
            teacherdao.getTeacherInfo(teacherid,loginteacher);  // 登录成功将用户信息保存
            return 0;
        }
    }

    /**
     * 获取当前用户全部信息。
     * @param teacherid 当前用户的ID。
     * @param teacher 需要传入的教师对象。
     */
    public static void getTeacherInfo(Teacher teacher,Integer teacherid) {
        TeacherDAO teacherdao = new TeacherDAO();
        teacherdao.getTeacherInfo(teacherid,teacher);
    }

    /**
     * 获取当前用户的姓名。
     * @param TeacherID 当前用户的ID。
     * @return String类型变量，值为当前用户姓名。
     */
    public static String getName(String TeacherID) {
        TeacherDAO teacherdao = new TeacherDAO();

        return teacherdao.getTeacherName(TeacherID);
    }

    /**
     * 获取当前用户的ID。
     * @param TeacherEmail 当前用户的Email。
     * @return Integer类型变量，值为当前用户ID。
     */
    public static Integer getTeacherIDByTeacherEmail (String TeacherEmail) {
        TeacherDAO teacherdao = new TeacherDAO();

        return teacherdao.getTeacherIDByTeacherEmail(TeacherEmail);
    }

}