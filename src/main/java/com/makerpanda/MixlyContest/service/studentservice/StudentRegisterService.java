package com.makerpanda.MixlyContest.service.studentservice;

import com.makerpanda.MixlyContest.dao.StudentDao;
import com.makerpanda.MixlyContest.datamodel.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentRegisterService {
    public static boolean StudentRegister (Student newstudent) {
        StudentDao studentdao = new StudentDao();

        return studentdao.insertNewStudent(newstudent);
    }
    /**
     * 测试数据库插入是否正常
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        Student student=new Student();
        student.setStudentID(10);
        student.setStudentIdentify("1234567");
        student.setStudentName("teacher");
        student.setStudentPassword("100");
        student.setStudentEmail("200");
        student.setStudentGender("男");
        student.setStudentTel("12345678901");
        student.setClassID(233);
        student.setTeacherID(1);
        student.setStudentSchool("电子科大");
        if(StudentRegister(student))
            System.out.println("插入成功\n");
        else
            System.out.println("插入失败\n");

    }

}
