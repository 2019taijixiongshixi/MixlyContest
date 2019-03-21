package com.makerpanda.MixlyContest.service.teacherservice;

import com.makerpanda.MixlyContest.MailUtil;
import com.makerpanda.MixlyContest.dao.TeacherDAO;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.verificationcodeservice.VerificationCodeService;
import org.springframework.stereotype.Service;


@Service
public class TeacherRegisterService {
    /**
     * 教师注册函数。
     * @param newteacher 新的教师对象。
     * @return 注册成功返回0,验证失败返回1,插入失败返回2
     */
    public static int TeacherRegister (Teacher newteacher,String verificationcode) {
        TeacherDAO teacherdao=new TeacherDAO();
        if(!VerificationCodeService.compareVerificationCode(verificationcode))
            return 1;
        if(!teacherdao.insertNewTeacher(newteacher))
            return 2;
        return 0;
    }
    /**
     * 测试数据库插入是否正常
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        teacher.setTeacherIdentify("1234567");
        teacher.setTeacherName("teacher");
        teacher.setTeachersProfessionalTitle("100");
        teacher.setTeacherCertificationID("200");
        teacher.setTeacherGender("男");
        teacher.setTeacherTel("12345678901");
        teacher.setTeacherEmail("271614896@qq.com");
        teacher.setTeacherPassword("12345");
        teacher.setTeacherSchool("电子科大");
        switch (MailUtil.getVerificationCode(teacher.getTeacherEmail())){
            case 1:
                System.out.println("发送邮件失败");
                break;
            case 2:
                System.out.println("数据库验证码插入失败");
                break;
            case 0:
                System.out.println("OK");
                break;
        }

    }

}
