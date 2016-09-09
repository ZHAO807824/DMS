package com.dms.util;

import java.security.MessageDigest;

/**
 * 后台返回信息cookit工具类
 * 
 * @author zhao
 *
 */
public class AuthUtil {
	// 盐值
	private static final String salt = "secret";
	// Cookie过期时间(10分钟)
	private static final Long time = 600000L;

	/**
	 * 对外暴露接口:生成cookie信息
	 * 
	 * @param id
	 * @param username
	 * @return
	 */
	public static String getAuth(Integer id, String username) {
		return id + ":" + (System.currentTimeMillis() + time) + ":" + getMD5(username);
	}
	

	/**
	 * 简单MD5加密
	 * 
	 * @param username
	 * @return
	 */
	public static String getMD5(String username) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = (username + salt).getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(AuthUtil.getAuth(1, "807824909@qq.com"));
	}
}
