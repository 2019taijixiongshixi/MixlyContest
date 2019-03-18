package com.makerpanda.MixlyContest;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootApplication
public class DBHelper {
    //	mysql数据库驱动
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    //	数据库连接URL
    private static final String url =
            "jdbc:mysql://132.232.116.82:3306/mixlycontest" +
                    "?serverTimezone=UTC";
    //	数据库用户名
    private static final String username = "clin";
    //	数据库密码
    private static final String password = "123456";
    //	数据库连接对象声明
    private static Connection conn = null;

    //	静态代码块负责加载驱动
    static {
        try {
            Class.forName(driver);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    // 单例模式返回数据库连接对象，供外部调用
    public static Connection getConnection() throws Exception {
        if (conn == null) {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        return conn;
    }

    /**
     * 用来关闭结果集和执行语句。
     */
    public static void closeResource(ResultSet resultSet, PreparedStatement pst) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (pst != null) {
                pst.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试数据库连接是否正常
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        try {
            Connection conn = DBHelper.getConnection();
            if (conn != null) {
                System.out.println("数据库连接正常");
            } else {
                System.out.println("数据库连接异常");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}