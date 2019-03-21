package com.makerpanda.MixlyContest.dao;

import com.makerpanda.MixlyContest.datamodel.Verificationcode;
import com.makerpanda.MixlyContest.DBHelper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.makerpanda.MixlyContest.DBHelper.closeResource;


@Repository
public class VerificationcodeDao {

    // 数据及库连接对象
    private static Connection conn = null;
    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;
    // 结果集
    private static ResultSet resultSet = null;

    /**
     * 根据时间戳VerificationCodeTime获取验证码字符串VerificationCodeString。
     * @return 若查询成功则返回String类型的字符串。否则，返回null。
     */
    public String getVerificationCodeString() {
        String VerificationCodeString = null;

        try {
            conn = DBHelper.getConnection();  // 从DBHelper获取连接对象
            // 创建PreparedStatement执行SQL语句
            pst = conn.prepareStatement("SELECT VerificationCodeTime FROM Verificationcode WHERE Verificationcodetime = " + VerificationCodeTime);  // 预处理语句
            resultSet = pst.executeQuery();  // 执行语句

            select * from tb1 where dDate>='2010-11-05' and dDate<='2010-11-15' and convert(char(8),dDate,108)>='8:00:00' and convert(char(8),dDate,108)<='9:00:00'.
                    
            // 获取用户密码
            if (resultSet.next()) {
                VerificationCodeString = resultSet.getString("VerificationCodeString");
            }

            return VerificationCodeString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResource(resultSet, pst);
        }
    }
}