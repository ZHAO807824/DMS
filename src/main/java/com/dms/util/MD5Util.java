package com.dms.util;

import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

/**
 * 对外提供getMD5加密
 * 
 * @author zhao
 *
 */
public class MD5Util {

	// 盐值
	private static final String SALT = "azxcvfsdfljflj344fdas4321dfas1fdas13fsda";

	public static String getMD5(String str) {
		try {
			// 确定计算方法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			// 加密后的字符串
			String password = base64en.encode(md5.digest((str+SALT).getBytes("utf-8")));
			return password;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args){
		System.out.println(MD5Util.getMD5("123456"));
	}
}
