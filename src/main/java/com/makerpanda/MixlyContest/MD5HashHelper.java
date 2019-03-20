package com.makerpanda.MixlyContest;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashHelper {
    /**
     * 计算出一个字符串的MD5值。
     * @param input 需要进行计算的字符串。
     * @return 输入字符串的MD5值。
     */
    private static String md5(String input) {
        String md5 = null;

        if (input == null) {
            return null;
        }

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(input.getBytes(), 0, input.length());
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return md5;
    }

    /**
     * 将密码计算为经加盐处理的MD5密码。
     * @param password 用户密码。
     * @return 经加盐处理的MD5密码。
     */
    public static String encryptPassword(String password) {
        String salt = "RandomSalt:23adfawe48-*/+***&#^$&()&^%$!@@#";
        return md5(password + salt);
    }

    /**
     * 测试经加盐处理后的MD5密码。
     * @param args 命令行参数。
     */
    public static void main(String[] args) {
        System.out.println(encryptPassword("12345"));
    }
}