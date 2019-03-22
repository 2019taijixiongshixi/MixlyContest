package com.makerpanda.MixlyContest.service.studentservice;

import com.makerpanda.MixlyContest.MailUtil;
import com.makerpanda.MixlyContest.dao.StudentDAO;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.service.verificationcodeservice.VerificationCodeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class StudentRegisterService {
    /**
     * 学生注册函数。
     * @param newstudent 新的学生对象。
     * @return 注册成功返回0,验证失败返回1,邮箱已注册返回2，没有班级号返回3，插入失败返回4
     */
    public static int StudentRegister (Student newstudent,String verificationcode) {
        StudentDAO studentdao=new StudentDAO();
        if(!VerificationCodeService.compareVerificationCode(verificationcode))
            return 1;
        if(checkStudentEmail(newstudent.getStudentEmail()))
            return 2;
        if(checkClassID(newstudent.getClassID()))
            return 3;
        if(!studentdao.insertNewStudent(newstudent))
            return 4;
        return 0;
    }
    /**
     *
     *@param Email 要检查的注册邮箱。
     *@return 邮箱已注册返回1，未注册返回0
     */
    public static boolean checkStudentEmail(String Email){
        StudentDAO studentdao=new StudentDAO();
        ArrayList arraylist=studentdao.selectStudentEmail();
        int i=0;
        for(;i<arraylist.size();i++)
            if(Email.equals(arraylist.get(i)))
                return true;
        return false;
    }
    /**
     *
     *@param classid 要检查的班级号。
     *@return 已有班级号返回1，没有班级号返回0
     */
    public static boolean checkClassID(Integer classid){
        StudentDAO studentdao=new StudentDAO();
        ArrayList arraylist=studentdao.selectStudentEmail();
        int i=0;
        for(;i<arraylist.size();i++)
            if(classid==arraylist.get(i))
                return true;
        return false;
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
