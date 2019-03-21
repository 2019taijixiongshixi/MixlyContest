package com.makerpanda.MixlyContest.service.studentservice;

import com.makerpanda.MixlyContest.MailUtil;
import com.makerpanda.MixlyContest.dao.StudentDAO;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.verificationcodeservice.VerificationCodeService;
import org.springframework.stereotype.Service;


@Service
public class StudentRegisterService {
    /**
     * 教师注册函数。
     * @param newstudent 新的教师对象。
     * @return 注册成功返回0,验证失败返回1,插入失败返回2
     */
    public static int StudentRegister (Student newstudent,String verificationcode) {
        StudentDAO studentdao=new StudentDAO();
        if(!VerificationCodeService.compareVerificationCode(verificationcode))
            return 1;
        if(!studentdao.insertNewStudent(newstudent))
            return 2;
        return 0;
    }
    /**
     * 测试数据库插入是否正常
     * @param args 命令行参数
     */

    public static void main(String[] args) {
        Student student=new Student();
        student.setStudentIdentify("1234567");
        student.setStudentName("teacher");
        student.setStudentPassword("100");
        student.setStudentEmail("136585610@qq.com");
        student.setStudentGender("男");
        student.setStudentTel("12345678901");
        student.setClassID(233);
        student.setTeacherID(1);
        student.setStudentSchool("电子科大");
        String code=null;
        switch (MailUtil.getVerificationCode(student.getStudentEmail())){
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
