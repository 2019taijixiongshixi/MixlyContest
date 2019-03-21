package com.makerpanda.MixlyContest.dao;

import com.makerpanda.MixlyContest.DBHelper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.makerpanda.MixlyContest.DBHelper.closeResource;


@Repository
public class VerificationCodeDAO {

    // 数据及库连接对象
    private static Connection conn = null;
    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;
    // 结果集
    private static ResultSet resultSet = null;

    /**
     * 根据获取验证码字符串VerificationCodeString。
     * @return 若查询成功则返回字符串数组。否则，返回null。
     */
    public ArrayList getVerificationCodeStringIn24Hour() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT VerificationCodeString from VerificationCode " +
                    "where VerificationCodeTime >=(NOW() - interval 24 hour)");  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句
            while (resultSet.next()) {
                // 将字符串对象添加进arrayList当中
                arrayList.add( resultSet.getString("VerificationCodeString"));
            }

            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }

    /**
     * 插入验证码
     * @param VerificationCodeString 需要插入的验证码。
     * @return 如果增加成功返回true，否则返回false。
     */
    public boolean insertVerificationCode(String VerificationCodeString) {
        String sql = "insert into VerificationCode (VerificationCodeString,VerificationCodeTime)"+
               "values(?,?)";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement(sql);
            pst.setString(1, VerificationCodeString);
            pst.setString(2, date);
            int rowsAffected = pst.executeUpdate();  // 执行语句

            return rowsAffected == 1;} catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResource(resultSet, pst);
        }
        return false;
    }


}