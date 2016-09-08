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
}
