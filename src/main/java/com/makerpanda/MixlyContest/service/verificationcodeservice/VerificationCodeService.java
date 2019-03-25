package com.makerpanda.MixlyContest.service.verificationcodeservice;

import com.makerpanda.MixlyContest.dao.VerificationCodeDAO;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.studentservice.StudentRegisterService;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherRegisterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;


@Service
public class VerificationCodeService {
   // public static String verificationcode;

    public static boolean insertVerificationCode(String VerificationCode) {
        VerificationCodeDAO verificationcodedao=new VerificationCodeDAO();

        return verificationcodedao.insertVerificationCode(VerificationCode);
    }

    public static boolean compareVerificationCode(String verificationcode) {
        VerificationCodeDAO verificationcodedao=new VerificationCodeDAO();
        ArrayList arraylist=verificationcodedao.getVerificationCodeStringIn24Hour();
        int i=0;
        for(;i<arraylist.size();i++)
            if(verificationcode.equals(arraylist.get(i)))
                return true;
        return false;

    }

    public static String verifyCode(){
        Random random = new Random();
        char[] set = {91,92,93,94,95,96,58,59,60,61,62,63,64};
        String str = "";
        while (str.length() != 6){
            boolean flag = true;
            int a = (random.nextInt(75) + 48);
            for (int j = 0; j < set.length; j++){
                if (a == set[j]){
                    flag = false;
                }
            }
            if (flag){
                char ch = (char) a;
                //System.out.println(a);
                str += ch;
            }
        }
        return str;
    }
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
        switch( StudentRegisterService.StudentRegister(student,"JKW4dS")) {
            case  1:
                System.out.println("验证失败");
                break;
            case  2:
                System.out.println("插入失败");
                break;
            case  0:
                System.out.println("OK");
                break;
        }
    }
}
