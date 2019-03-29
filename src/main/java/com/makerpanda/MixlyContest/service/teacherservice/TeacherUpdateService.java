package com.makerpanda.MixlyContest.service.teacherservice;

import com.makerpanda.MixlyContest.dao.TeacherDAO;
import com.makerpanda.MixlyContest.datamodel.Teacher;

public class TeacherUpdateService {
    /**
     * 教师信息修改函数。
     * @param teacher 新的教师对象。
     * @return 注册成功返回0,验证失败返回1,邮箱已注册返回2,插入失败返回3
     */
    public static int TeacherUpdateInfo (Teacher teacher, String verificationcode) {
        TeacherDAO teacherdao=new TeacherDAO();

        return 0;
    }

    /**
     * 教师信息修改函数。
     * @param teacher 新的教师对象。
     * @return 注册成功返回0,验证失败返回1,邮箱已注册返回2,插入失败返回3
     */
    public static int TeacherUpdatePassword (String Password) {
        TeacherDAO teacherdao=new TeacherDAO();

        return 0;
    }
}
