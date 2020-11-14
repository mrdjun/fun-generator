package com.fun.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @author DJun
 * @date 2020/1/28
 */
public class MD5Utils {
    private static final String HEX_NUMS_STR = "0123456789ABCDEF";
    private static final Integer SALT_LENGTH = 6;

    /**
     * 将16进制字符串转换成字节数组
     *
     * @param hex hex
     * @return byte[]
     */
    private static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] hexChars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4
                    | HEX_NUMS_STR.indexOf(hexChars[pos + 1]));
        }
        return result;
    }

    /**
     * 将指定byte数组转换成16进制字符串
     *
     * @param b byte[]
     * @return String
     */
    private static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (byte value : b) {
            String hex = Integer.toHexString(value & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toUpperCase());
        }
        return hexString.toString();
    }

    /**
     * 获得加密后的16进制形式口令
     *
     * @param password password
     * @return String
     * @throws NoSuchAlgorithmException     e
     */
    public static String getEncryptedPwd(String password)
            throws NoSuchAlgorithmException {
        byte[] pwd = null;
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        MessageDigest md = null;
        md = MessageDigest.getInstance("MD5");
        md.update(salt);
        md.update(password.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        //因为要在口令的字节数组中存放盐，所以加上盐的字节长度
        pwd = new byte[digest.length + SALT_LENGTH];
        //将盐的字节拷贝到生成的加密口令字节数组的前12个字节，以便在验证口令时取出盐
        System.arraycopy(salt, 0, pwd, 0, SALT_LENGTH);
        //将消息摘要拷贝到加密口令字节数组从第13个字节开始的字节
        System.arraycopy(digest, 0, pwd, SALT_LENGTH, digest.length);
        //将字节数组格式加密后的口令转化为16进制字符串格式的口令
        return byteToHexString(pwd);
    }

    /**
     * 验证密码
     *
     * @param password   密码
     * @param encryptPwd 数据库获取的加密密码
     * @return bool
     * @throws NoSuchAlgorithmException     e
     */
    public static boolean validPassword(String password, String encryptPwd)
            throws NoSuchAlgorithmException {
        //将16进制字符串格式口令转换成字节数组
        byte[] pwdInDb = hexStringToByte(encryptPwd);
        //声明盐变量
        byte[] salt = new byte[SALT_LENGTH];
        //将盐从数据库中保存的口令字节数组中提取出来
        System.arraycopy(pwdInDb, 0, salt, 0, SALT_LENGTH);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(salt);
        md.update(password.getBytes(StandardCharsets.UTF_8));
        byte[] digestInDb = new byte[pwdInDb.length - SALT_LENGTH];
        System.arraycopy(pwdInDb, SALT_LENGTH, digestInDb, 0, digestInDb.length);
        return Arrays.equals(md.digest(), digestInDb);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String pwd = getEncryptedPwd("admin");
        System.out.println(pwd);
        System.out.println(validPassword("admin", pwd));
    }
}
