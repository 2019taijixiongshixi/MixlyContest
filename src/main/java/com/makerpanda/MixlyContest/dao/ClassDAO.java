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
     * 根据ClassID，获取Class全部信息。
     * @param ClassID 需要获取信息的教师ID。
     * @return 如果能够查询到ClassID的信息，则返回一个Class类型的对象，其中数据域为该Class信息。否则，返回null。
     */
    public Class getClassInfo(Integer ClassID) {
        Class aclass = null;

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT * FROM Class WHERE id = " + ClassID);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            // 获得class信息
            if (resultSet.next()) {
                aclass = new Class();
                aclass.setClassID(resultSet.getInt("ClassID"));
                aclass.setTeacherID(resultSet.getInt("TeacherID"));
            }
            return aclass;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }
}
