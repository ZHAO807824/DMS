package com.dms.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.dms.config.Constant;

/**
 * 配置文件工具类
 * 
 * @author zhao
 *
 */
public class PropertiesUtil {

	/**
	 * 通过key在配置文件中获取其value
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
