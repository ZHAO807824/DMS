package com.dms.util;

import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

/**
 * �����ṩgetMD5����
 * 
 * @author zhao
 *
 */
public class MD5Util {

	// ��ֵ
	private static final String SALT = "azxcvfsdfljflj344fdas4321dfas1fdas13fsda";

	public static String getMD5(String str) {
		try {
			// ȷ�����㷽��
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			// ���ܺ���ַ���
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
