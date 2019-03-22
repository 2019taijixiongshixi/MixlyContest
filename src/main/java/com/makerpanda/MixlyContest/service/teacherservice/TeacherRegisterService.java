package com.makerpanda.MixlyContest.service.teacherservice;

import com.makerpanda.MixlyContest.MailUtil;
import com.makerpanda.MixlyContest.dao.TeacherDAO;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.verificationcodeservice.VerificationCodeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class TeacherRegisterService {
    /**
     * 教师注册函数。
     * @param newteacher 新的教师对象。
     * @return 注册成功返回0,验证失败返回1,邮箱已注册返回2,插入失败返回3
     */
    public static int TeacherRegister (Teacher newteacher,String verificationcode) {
        TeacherDAO teacherdao=new TeacherDAO();
        if(!VerificationCodeService.compareVerificationCode(verificationcode))
            return 1;
        if(checkTeacherEmail(newteacher.getTeacherEmail()))
           return 2;
        if(!teacherdao.insertNewTeacher(newteacher))
            return 3;
        return 0;
    }

    /**
     *
     *@param Email 要检查的注册邮箱。
     *@return 邮箱已注册返回1，未注册返回0
     */
    public static boolean checkTeacherEmail(String Email){
        TeacherDAO teacherdao=new TeacherDAO();
        ArrayList arraylist=teacherdao.selectTeacherEmail();
        int i=0;
        for(;i<arraylist.size();i++)
            if(Email.equals(arraylist.get(i)))
                return true;
        return false;
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
        teacher.setTeacherEmail("854574591@qq.com");
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
