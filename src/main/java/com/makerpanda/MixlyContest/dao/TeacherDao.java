package com.makerpanda.MixlyContest.dao;

import com.makerpanda.MixlyContest.datamodel.Teacher;
import com.makerpanda.MixlyContest.DBHelper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.makerpanda.MixlyContest.DBHelper.closeResource;


@Repository
public class TeacherDao {

    // 数据及库连接对象
    private static Connection conn = null;
    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;
    // 结果集
    private static ResultSet resultSet = null;

    /**
     * 获取全部用户信息。
     * @return Teacher类型的ArrayList集合，其中每个teacher对象是一个教师。
     */
    public ArrayList getTeachers() {
        ArrayList<Teacher> arrayList = new ArrayList<>();

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT * FROM Teacher");  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 遍历处理结果集，获得每一行数据
            while (resultSet.next()) {
                Teacher teacher = new Teacher();

                teacher.setTeacherID(resultSet.getString("TeacherID"));
                teacher.setTeacherName(resultSet.getString("TeacherName"));
                teacher.setTeachersProfessionalTitle(resultSet.getString("TeachersProfessionalTitle"));
                teacher.setTeacherCertificationID(resultSet.getString("TeacherCertificationID"));
                teacher.setTeacherGender(resultSet.getString("TeacherGender"));
                teacher.setTeacherTel(resultSet.getString("TeacherTel"));
                teacher.setTeacherEmail(resultSet.getString("TeacherEmail"));
                teacher.setTeacherPassword(resultSet.getString("TeacherPassword"));
                // 将user对象添加进arrayList当中
                arrayList.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResource(resultSet, pst);
        }

        return arrayList;
    }

    /**
     * 根据教师ID获取教师的密码。
     * @param TeacherID 需要查询密码的教师ID。
     * @return 若查询成功则返回String类型的密码，若教师用户名不存在则返回null。
     */
    public String getTeacherPassword(String TeacherID) {
        String password = null;

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT TeacherPassword FROM Teacher WHERE id = " + TeacherID);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 获取用户密码
            if (resultSet.next()) {
                password = resultSet.getString("TeacherPassword");
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
     * 根据教师ID，获取教师全部信息。
     * @param TeacherID 需要获取信息的教师ID。
     * @return 如果能够查询到TeacherID的信息，则返回一个Teacher类型的对象，其中数据域为该用户信息。否则，返回null。
     */
    public Teacher getTeacherInfo(String TeacherID) {
        Teacher teacher = null;

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT * FROM Teacher WHERE id = " + TeacherID);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 获得用户信息
            if (resultSet.next()) {
                teacher = new Teacher();

                teacher.setTeacherID(resultSet.getString("TeacherID"));
                teacher.setTeacherName(resultSet.getString("TeacherName"));
                teacher.setTeachersProfessionalTitle(resultSet.getString("TeachersProfessionalTitle"));
                teacher.setTeacherCertificationID(resultSet.getString("TeacherCertificationID"));
                teacher.setTeacherGender(resultSet.getString("TeacherGender"));
                teacher.setTeacherTel(resultSet.getString("TeacherTel"));
                teacher.setTeacherEmail(resultSet.getString("TeacherEmail"));
                teacher.setTeacherPassword(resultSet.getString("TeacherPassword"));
            }

            return teacher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }

    /**
     * 获取教师姓名。
     * @param TeacherID 需要查询姓名的教师ID。
     * @return 如果查询到姓名则返回String类型该姓名，否则返回null。
     */
    public String getTeacherName(String TeacherID) {
        String teachername = null;

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT TeacherName FROM Teacher WHERE id = " + TeacherID);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 获取用户姓名
            if (resultSet.next()) {
                teachername = resultSet.getString("TeacherName");
            }

            return teachername;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }

    /**
     * 获取教师ID。
     * @param TeacherEmail 需要查询ID的教师邮箱。
     * @return 如果查询到ID则返回string类型ID，否则返回null。
     */
    public String getTeacherIDByTeacherEmail(String TeacherEmail) {
        String teacherid=null;

        try {
            String sql = "SELECT TeacherID FROM Teacher WHERE TeacherEmail = "+TeacherEmail;
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);  // 预处理语句
            pst.setString(1, TeacherEmail);
            resultSet = pst.executeQuery();  // 执行语句

            // 获取用户ID
            if (resultSet.next()) {
                teacherid=resultSet.getString("TeacherID");
            }

            return teacherid;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }

//    /**
//     * 增加新的教师用户
//     * @param newTeacher 新的教师对象。
//     * @return 如果增加成功返回true，否则返回false。
//     */
//    public boolean insertNewTeacher(Teacher newTeacher) {
//
//        try {
//            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
//            // 创建PreparedStatement执行SQL语句
//            pst = conn.prepareStatement("INSERT User SET password = '" + newPassword +
//                    "' WHERE user_id = " + userID);
//            int rowsAffected = pst.executeUpdate();  // 执行语句
//
//            return rowsAffected == 1;
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            closeResource(resultSet, pst);
//        }
//        return false;
//    }
}
