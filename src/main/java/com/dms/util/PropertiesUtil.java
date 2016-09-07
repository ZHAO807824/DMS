package com.dms.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.dms.config.Constant;

/**
 * ��ȡ�����ļ�����
 * 
 * @author zhao
 *
 */
public class PropertiesUtil {

	/**
	 * ��ϵͳ�����ļ���ͨ��key��ȡvalue
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		Properties prop = new Properties();
		InputStream in = new PropertiesUtil().getClass().getResourceAsStream("/" + Constant.DMS_PROPERTIES);
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (String) prop.get(key);
	}
}
