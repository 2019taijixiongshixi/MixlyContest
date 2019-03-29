package com.makerpanda.MixlyContest.service.teacherservice;

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

}
