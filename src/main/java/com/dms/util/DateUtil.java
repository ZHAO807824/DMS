package com.dms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间处理
 * 
 * @author zhao
 *
 */
public class DateUtil {

	/**
	 * 根据传入的Date和format获取日期时间字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (date != null) {
			result = sdf.format(date);
		}
		return result;
	}

	/**
	 * 根据传入的日期时间字符串和format获取Date
	 * 
	 * @param str
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static Date formatString(String str, String format) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(str);
	}
}
