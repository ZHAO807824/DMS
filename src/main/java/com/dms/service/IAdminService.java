package com.dms.service;

import com.dms.entity.Admin;
import com.dms.entity.user.User;

/**
 * 
 * @author zhao
 *
 */
public interface IAdminService {
	
	/**
	 * 登录
	 * @param email
	 * @param password
	 * @return
	 */
	public Admin login(String email,String password);
	
	/**
	 * 校验在线状态
	 * @param value
	 * @return
	 */
	public boolean check(String value);
	
	/**
	 * 校验邮箱是否存在
	 * @param email
	 * @return:true 存在 , false 不存在
	 */
	public boolean checkEmail(String email);
	
	/**
	 * 注册
	 * @param admin
	 * @param user
	 * @return
	 */
	public boolean register(Admin admin,User user);
}
