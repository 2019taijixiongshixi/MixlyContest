package com.makerpanda.MixlyContest.service.studentservice;

import com.makerpanda.MixlyContest.MailUtil;
import com.makerpanda.MixlyContest.dao.ClassDAO;
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
        ClassDAO classdao=new ClassDAO();
        if(!VerificationCodeService.compareVerificationCode(verificationcode))
            return 1;
        if(checkStudentEmail(newstudent.getStudentEmail()))
            return 2;
        if(!checkClassID(newstudent.getClassID()))
            return 3;
        newstudent.setTeacherID(classdao.getTeacherIDByClassID(newstudent.getClassID()));
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
        ClassDAO classdao=new ClassDAO();
        ArrayList arraylist=classdao.selectClassID();
        int i=0;
        for(;i<arraylist.size();i++)
            if (classid.toString().equals(arraylist.get(i))) {
                return true;
            }
        return false;
    }
}
