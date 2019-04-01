package com.makerpanda.MixlyContest.service.studentservice;

import com.makerpanda.MixlyContest.dao.StudentDAO;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.verificationcodeservice.VerificationCodeService;
import org.springframework.stereotype.Service;

@Service
public class StudentUpdateService {
    /**
     * 学生密码修改函数。
     * @param newPassword 新的密码。
     * @param email 邮箱。
     * @return 修改成功返回0,验证失败返回1,找不到邮箱返回2,更新失败返回3
     */
    public static int StudentUpdatePassword (String verificationcode,
                                             String newPassword,String email) {
        StudentDAO studentdao=new StudentDAO();
        if(!VerificationCodeService.compareVerificationCode(verificationcode))
            return 1;
        if(!StudentRegisterService.checkStudentEmail(email))
            return 2;
        Integer studentid=studentdao.getStudentIDByStudentEmail(email);
        if(!studentdao.updateStudentPassword(newPassword,studentid))
            return 3;
        return 0;
    }

    /**
     * 学生信息修改函数。
     * @param student 新的学生对象。
     * @return 修改成功返回0,修改失败返回1
     */
    public static boolean StudentUpdateInfo (Student student) {
        StudentDAO studentdao=new StudentDAO();
        return studentdao.updateStudentInfo(student);
    }
}
