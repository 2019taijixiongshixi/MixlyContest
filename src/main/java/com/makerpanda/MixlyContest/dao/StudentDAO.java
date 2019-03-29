package com.makerpanda.MixlyContest.dao;

import com.makerpanda.MixlyContest.MD5HashHelper;
import com.makerpanda.MixlyContest.datamodel.Student;
import com.makerpanda.MixlyContest.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.makerpanda.MixlyContest.DBHelper.closeResource;

public class StudentDAO {
    // 数据及库连接对象
    private static Connection conn = null;
    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;
    // 结果集
    private static ResultSet resultSet = null;

    /**
     * 获取全部用户信息。
     * @return Student类型的ArrayList集合，其中每个student对象是一个学生。
     */
    public ArrayList getStudents() {
        ArrayList<Student> arrayList = new ArrayList<>();

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT * FROM Student");  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 遍历处理结果集，获得每一行数据
            while (resultSet.next()) {
                Student student = new Student();

                student.setStudentID(resultSet.getInt("StudentID"));
                student.setStudentIdentify(resultSet.getString("StudentIdentify"));
                student.setProjectID(resultSet.getInt("ProjectID"));
                student.setStudentName(resultSet.getString("StudentName"));
                student.setStudentGender(resultSet.getString("StudentGander"));
                student.setStudentTel(resultSet.getString("StudentTel"));
                student.setStudentEmail(resultSet.getString("StudentEmail"));
                student.setClassID(resultSet.getInt("ClassID"));
                student.setStudentSchool(resultSet.getString("School"));
                student.setStudentPassword(resultSet.getString("StudentPassword"));
                student.setTeacherID(resultSet.getInt("TeacherID"));
                // 将user对象添加进arrayList当中
                arrayList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(resultSet, pst);
        }

        return arrayList;
    }

    /**
     * 根据学生ID获取学生的密码。
     * @param StudentID 需要查询密码的学生ID。
     * @return 若查询成功则返回String类型的密码，若学生用户名不存在则返回null。
     */
    public String getStudentPassword(Integer StudentID) {
        String password = null;

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT StudentPassword FROM Student WHERE StudentID = " + StudentID);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 获取用户密码
            if (resultSet.next()) {
                password = resultSet.getString("StudentPassword");
            }

            return password;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }

    /**
     * 根据学生ID，获取学生全部信息。
     * @param StudentID 需要获取信息的学生ID。
     * @return 如果能够查询到StudentID的信息，则返回一个Student类型的对象，其中数据域为该用户信息。否则，返回null。
     */
    public Student getStudentInfo(Integer StudentID) {
        Student student = null;

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT * FROM Student WHERE StudentID = " + StudentID);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 获得用户信息
            if (resultSet.next()) {
                student = new Student();

                student.setStudentID(resultSet.getInt("StudentID"));
                student.setStudentIdentify(resultSet.getString("StudentIdentify"));
                student.setProjectID(resultSet.getInt("ProjectID"));
                student.setStudentName(resultSet.getString("StudentName"));
                student.setStudentGender(resultSet.getString("StudentGander"));
                student.setStudentTel(resultSet.getString("StudentTel"));
                student.setStudentEmail(resultSet.getString("StudentEmail"));
                student.setClassID(resultSet.getInt("ClassID"));
                student.setStudentSchool(resultSet.getString("School"));
                student.setStudentPassword(resultSet.getString("StudentPassword"));
                student.setTeacherID(resultSet.getInt("TeacherID"));
            }

            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }

    /**
     * 获取学生姓名。
     * @param StudentID 需要查询姓名的学生ID。
     * @return 如果查询到姓名则返回String类型该姓名，否则返回null。
     */
    public String getStudentName(Integer StudentID) {
        String studentname = null;

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT StudentName FROM Student WHERE StudentID = " + StudentID);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 获取用户姓名
            if (resultSet.next()) {
                studentname = resultSet.getString("StudentName");
            }

            return studentname;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }


    /**
     * 获取学生ID。
     * @param StudentEmail 需要查询ID的学生邮箱。
     * @return 如果查询到ID则返回int类型ID，否则返回null。
     */
    public Integer getStudentIDByStudentEmail(String StudentEmail) {
        Integer studentid=null;

        try {
            String sql = "SELECT StudentID FROM Student WHERE StudentEmail = "+StudentEmail;
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 获取用户ID
            if (resultSet.next()) {
                studentid=resultSet.getInt("StudentID");
            }

            return studentid;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }

    /**
     * 增加新的学生用户
     * @param newStudent 新的学生对象。
     * @return 如果增加成功返回true，否则返回false。
     */
    public boolean insertNewStudent(Student newStudent) {
        String sql = "insert into Student (StudentIdentify,StudentPassword," +
                "StudentEmail,StudentTel,StudentGender,StudentName," +
                "School,ClassID,TeacherID) " +
                "values(?,?,?,?,?,?,?,?,?)";
        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);
            pst.setString(1, newStudent.getStudentIdentify());
            pst.setString(2,
                    MD5HashHelper.encryptPassword(newStudent.getStudentPassword()));
            pst.setString(3,newStudent.getStudentEmail());
            pst.setString(4,newStudent.getStudentTel());
            pst.setString(5,newStudent.getStudentGender());
            pst.setString(6,newStudent.getStudentName());
            pst.setString(7,newStudent.getStudentSchool());
            pst.setInt(8,newStudent.getClassID());
            pst.setInt(9,newStudent.getTeacherID());

            int rowsAffected = pst.executeUpdate();  // 执行语句

            return rowsAffected == 1;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResource(resultSet, pst);
        }
        return false;
    }
    /**
     * 查询所有学生邮箱。
     * @return 若查询成功则返回字符串数组。否则，返回null。
     */
    public ArrayList selectStudentEmail() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String sql = "SELECT StudentEmail FROM Student";
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            while (resultSet.next()) {
                // 将字符串对象添加进arrayList当中
                arrayList.add(resultSet.getString("StudentEmail"));
            }
            return arrayList;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }
    public boolean updateStudentInfo(Student student) {
        String sql = "update Student set StudentIdentify=?,StudentPassword=? ," +
                "StudentEmail=?, StudentTel=? ,StudentGender=?, StudentName=?, " +
                "ClassID=?,School=?, ProjectID=?, TeacherID=? where StudentID=?";
        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);
            pst.setString(1, student.getStudentIdentify());
            pst.setString(2,
                    MD5HashHelper.encryptPassword(student.getStudentPassword()));
            pst.setString(3, student.getStudentEmail());
            pst.setString(4,student.getStudentTel());
            pst.setString(5, student.getStudentGender());
            pst.setString(6,student.getStudentName());
            pst.setInt(7,student.getClassID());
            pst.setString(8,student.getStudentSchool());
            pst.setInt(9,student.getProjectID());
            pst.setInt(10,student.getTeacherID());
            pst.setInt(11,student.getStudentID());
            int rowsAffected = pst.executeUpdate();  // 执行语句
            return rowsAffected == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeResource(resultSet, pst);
        }
        return false;
    }
    public boolean updateStudentPassword(String newPassword,Integer StudentID) {
        String sql = "update Student set StudentPassword=? where StudentID=?";
        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);
            pst.setString(1,
                    MD5HashHelper.encryptPassword(newPassword));
            pst.setInt(2,StudentID);
            int rowsAffected = pst.executeUpdate();  // 执行语句
            return rowsAffected == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeResource(resultSet, pst);
        }
        return false;
    }
}