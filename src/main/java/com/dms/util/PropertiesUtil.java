package com.dms.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.dms.config.Constant;

/**
 * 读取配置文件参数
 * 
 * @author zhao
 *
 */
public class PropertiesUtil {

	/**
	 * 在系统参数文件中通过key获取value
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
