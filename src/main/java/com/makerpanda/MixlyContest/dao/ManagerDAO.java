package com.makerpanda.MixlyContest.dao;

import com.makerpanda.MixlyContest.DBHelper;
import com.makerpanda.MixlyContest.datamodel.Manager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.makerpanda.MixlyContest.DBHelper.closeResource;

@Repository
public class ManagerDAO {

        // 数据及库连接对象
        private static Connection conn = null;
        // PreparedStatement对象用来执行SQL语句
        private static PreparedStatement pst = null;
        // 结果集
        private static ResultSet resultSet = null;

        //获取ID对应的Password
        public String getPassword(String ManagerID) {

            try {
                conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
                // 创建PreparedStatement执行SQL语句
                pst = conn.prepareStatement("SELECT Password FROM Manager WHERE ManagerID=?");  // 预处理语句
                pst.setString(1, ManagerID);
                resultSet = pst.executeQuery();  // 执行语句
                if (resultSet.next()) {
                    return resultSet.getString(1);
                } else
                    return null;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeResource(resultSet, pst);
            }

            return null;
        }

}
