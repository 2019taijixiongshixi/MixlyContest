package com.makerpanda.MixlyContest.dao;

import com.makerpanda.MixlyContest.DBHelper;
import com.makerpanda.MixlyContest.datamodel.Class;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.makerpanda.MixlyContest.DBHelper.closeResource;

    @Repository
    public class ClassDAO {

        // 数据及库连接对象
        private static Connection conn = null;
        // PreparedStatement对象用来执行SQL语句
        private static PreparedStatement pst = null;
        // 结果集
        private static ResultSet resultSet = null;

        /**
         * 获取全部Class信息。
         * @return Teacher类型的ArrayList集合，其中每个teacher对象是一个教师。
         */
        public ArrayList getClasses() {
            ArrayList<Class> arrayList = new ArrayList<>();

            try {
                conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
                // 创建PreparedStatement执行SQL语句
                pst = conn.prepareStatement("SELECT * FROM Class");  // 预处理语句
                resultSet = pst.executeQuery();  // 执行语句

                // 遍历处理结果集，获得每一行数据
                while (resultSet.next()) {
                    Class aclass = new Class();

                    aclass.setClassID(resultSet.getInt("ClassID"));
                    aclass.setTeacherID(resultSet.getInt("TeacherID"));
                    // 将user对象添加进arrayList当中
                    arrayList.add(aclass);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeResource(resultSet, pst);
            }

            return arrayList;
        }

        /**
         * 查询所有ClassID。
         * @return 若查询成功则返回Integer数组。否则，返回null。
         */
        public ArrayList selectClassID() {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                String sql = "SELECT ClassID FROM Class";
                conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
                // 创建PreparedStatement执行SQL语句
                pst = conn.prepareStatement(sql);  // 预处理语句
                resultSet = pst.executeQuery();  // 执行语句

                while (resultSet.next()) {
                    // 将字符串对象添加进arrayList当中
                    arrayList.add(resultSet.getString("ClassID"));
                }
                return arrayList;
            }catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                closeResource(resultSet, pst);
            }
        }

        public boolean createClass(Integer teacherid){
            String sql="INSERT INTO Class (TeacherID)"+
                    "VALUES(?)";
            try {
                conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
                // 创建PreparedStatement执行SQL语句
                pst = conn.prepareStatement(sql);  // 预处理语句
                pst.setInt(1, teacherid);
                int rowsAffected = pst.executeUpdate();  // 执行语句

                return  rowsAffected == 1;} catch (Exception e){
                e.printStackTrace();
            } finally {
                closeResource(resultSet, pst);
            }
            return false;
        }

        /**
         * 根据ClassID，获取TeacherID。
         * @param ClassID 需要获取信息的ClassID。
         * @return 如果能够查询到ClassID的信息，则返回一个Integer类型的教师id，其中数据域为该Class信息。否则，返回null。
         */
        public Integer getTeacherIDByClassID(Integer ClassID) {
            Integer teacherid = null;
            String sql="SELECT TeacherID FROM Class WHERE ClassID = ?";
            try {
                conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
                // 创建PreparedStatement执行SQL语句
                pst = conn.prepareStatement(sql);  // 预处理语句
                pst.setInt(1, ClassID);
                resultSet = pst.executeQuery();  // 执行语句

                // 获得class信息
                if (resultSet.next()) {
                    teacherid=(resultSet.getInt("TeacherID"));
                }
                return teacherid;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                closeResource(resultSet, pst);
            }
        }
        /**
         * 根据ClassID，获取TeacherID。
         * @param ClassID 需要获取信息的ClassID。
         * @return 如果能够查询到ClassID的信息，则返回一个Integer类型的教师id，其中数据域为该Class信息。否则，返回null。
         */
        public Integer getClassIDByTeacherID(Integer ClassID) {
            Integer teacherid = null;
            String sql="SELECT TeacherID FROM Class WHERE ClassID = ?";
            try {
                conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
                // 创建PreparedStatement执行SQL语句
                pst = conn.prepareStatement(sql);  // 预处理语句
                pst.setInt(1, ClassID);
                resultSet = pst.executeQuery();  // 执行语句

                // 获得class信息
                if (resultSet.next()) {
                    teacherid=(resultSet.getInt("TeacherID"));
                }
                return teacherid;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                closeResource(resultSet, pst);
            }
        }
}
