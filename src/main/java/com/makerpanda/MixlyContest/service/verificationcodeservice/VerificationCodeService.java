package com.makerpanda.MixlyContest.service.verificationcodeservice;

import com.makerpanda.MixlyContest.dao.VerificationCodeDAO;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.service.teacherservice.TeacherRegisterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

import static com.makerpanda.MixlyContest.service.teacherservice.TeacherRegisterService.TeacherRegister;

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
        Teacher teacher=new Teacher();
        teacher.setTeacherIdentify("1234567");
        teacher.setTeacherName("teacher");
        teacher.setTeachersProfessionalTitle("100");
        teacher.setTeacherCertificationID("200");
        teacher.setTeacherGender("男");
        teacher.setTeacherTel("12345678901");
        teacher.setTeacherEmail("271614896.com");
        teacher.setTeacherPassword("12345");
        teacher.setTeacherSchool("电子科大");
        String code=null;
        switch( TeacherRegisterService.TeacherRegister(teacher,"EyeKYr")) {
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
