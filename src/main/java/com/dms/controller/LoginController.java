package com.dms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dms.config.Constant;
import com.dms.util.PropertiesUtil;

/**
 * 
 * @author zhao
 *
 */
@Controller
public class LoginController {

	/**
	 * ��ʼ��¼ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("index.action")
	public String index() {
		return PropertiesUtil.getValue(Constant.STYLE_DMS) + "/login";
	}
}
