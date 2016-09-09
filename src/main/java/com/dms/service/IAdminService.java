package com.dms.service;

import com.dms.entity.Admin;

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
}
