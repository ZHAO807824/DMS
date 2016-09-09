package com.dms.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dms.config.Constant;
import com.dms.entity.Admin;
import com.dms.kit.AdminKit;
import com.dms.service.IAdminService;
import com.dms.service.user.IStudentService;
import com.dms.util.AuthUtil;
import com.dms.util.PropertiesUtil;
import com.dms.util.ValidatorUtil;

/**
 * 
 * @author zhao
 *
 */
@Controller
@SuppressWarnings("all")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IAdminService adminService;

	@Autowired
	private IStudentService studentService;

	/**
	 * 初始登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/index.action")
	public String index() {
		return PropertiesUtil.getValue(Constant.STYLE_DMS) + "/login";
	}

	/**
	 * 登录
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String email, String password, HttpServletResponse response) {
		if (ValidatorUtil.isEmail(email)) {
			Admin admin = adminService.login(email, password);
			if (admin != null) {
				// Cookie
				Cookie auth = new Cookie("auth", AuthUtil.getAuth(admin.getId(), admin.getEmail()));
				response.addCookie(auth);
				// Admin
				new AdminKit(admin);
				return PropertiesUtil.getValue(Constant.STYLE_DMS) + "/home";
			}
		}
		return PropertiesUtil.getValue(Constant.STYLE_DMS) + "/login";
	}
}
