package com.makerpanda.MixlyContest.service.teacherservice;

import com.makerpanda.MixlyContest.dao.TeacherDAO;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.verificationcodeservice.VerificationCodeService;

public class TeacherUpdateService {
    /**
     * 教师密码修改函数。
     * @param newPassword 新的密码。
     * @param email 邮箱。
     * @return 修改成功返回0,验证失败返回1,找不到邮箱返回2,更新失败返回3
     */
    public static int TeacherUpdatePassword (String verificationcode,
                                             String newPassword,String email) {
        TeacherDAO teacherdao=new TeacherDAO();
        if(!VerificationCodeService.compareVerificationCode(verificationcode))
            return 1;
        if(!TeacherRegisterService.checkTeacherEmail(email))
            return 2;
        Integer teacherid=teacherdao.getTeacherIDByTeacherEmail(email);
        if(!teacherdao.updateTeacherPassword(newPassword,teacherid))
            return 3;
        return 0;
    }

    /**
     * 教师信息修改函数。
     * @param teacher 新的教师对象。
     * @return 修改成功返回0,修改失败返回1
     */
    public static boolean TeacherUpdateInfo (Teacher teacher) {
        TeacherDAO teacherdao=new TeacherDAO();
        return teacherdao.updateTeacherInfo(teacher);
    }


}
