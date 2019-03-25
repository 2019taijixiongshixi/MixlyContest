package com.makerpanda.MixlyContest.service.teacherservice;

import com.makerpanda.MixlyContest.dao.TeacherDao;
import com.makerpanda.MixlyContest.datamodel.Teacher;
import org.springframework.stereotype.Service;

@Service
public class TeacherRegisterService {
    public static boolean TeacherRegister (Teacher newteacher) {
        TeacherDao teacherdao = new TeacherDao();

        return teacherdao.insertNewTeacher(newteacher);
    }
    /**
     * 测试数据库插入是否正常
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        teacher.setTeacherID(11);
        teacher.setTeacherIdentify("1234567");
        teacher.setTeacherName("teacher");
        teacher.setTeachersProfessionalTitle("100");
        teacher.setTeacherCertificationID("200");
        teacher.setTeacherGender("男");
        teacher.setTeacherTel("12345678901");
        teacher.setTeacherEmail(".com");
        teacher.setTeacherPassword("12345");
        teacher.setTeacherSchool("电子科大");

           if(TeacherRegister(teacher))
            System.out.println("插入成功\n");
        else
            System.out.println("插入失败\n");

    }

}
