package com.dms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ�䴦��
 * 
 * @author zhao
 *
 */
public class DateUtil {

	/**
	 * ���ݴ����Date��format��ȡ����ʱ���ַ���
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
	 * ���ݴ��������ʱ���ַ�����format��ȡDate
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
