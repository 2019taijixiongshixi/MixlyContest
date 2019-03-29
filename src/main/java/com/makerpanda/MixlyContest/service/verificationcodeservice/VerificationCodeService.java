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
}
