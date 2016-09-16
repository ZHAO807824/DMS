package com.dms.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dms.config.Constant;
import com.dms.dto.Result;
import com.dms.entity.Admin;
import com.dms.entity.user.User;
import com.dms.kit.AdminKit;
import com.dms.service.IAdminService;
import com.dms.util.AuthUtil;
import com.dms.util.MD5Util;
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

	/**
	 * 初始登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
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
	@RequestMapping(value = "/login", method = RequestMethod.POST)
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

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return PropertiesUtil.getValue(Constant.STYLE_DMS) + "/register";
	}

	/**
	 * 注册前校验email是否存在
	 * 
	 * @param email
	 * @return:true 验证通过;false 验证失败
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public boolean register(@RequestParam(value = "email", required = true) String email) {
		return adminService.checkEmail(email) == true ? false : true;
	}

	/**
	 * 注册
	 * 
	 * @param fullname
	 * @param username
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public boolean register(String fullName, String houseName, String gender, String email, String password) {
		User user = new User(fullName, houseName, gender);
		Admin admin = new Admin(email, MD5Util.getMD5(password));
		try {
			return adminService.register(admin, user);
		} catch (Exception e) {
			LOGGER.info("LoginController register(String,String,String,String,String):" + e.getMessage());
		}
		return false;
	}
}
