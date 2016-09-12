package com.dms.dao;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Admin;

/**
 * 
 * @author zhao
 *
 */
public interface IAdminDao {

	/**
	 * 查询用户
	 * @param email
	 * @param password
	 * @return
	 */
	public Admin findOne(@Param(value = "email") String email,@Param(value = "password") String password);

	/**
	 * 查询Email
	 * @param id
	 * @return
	 */
	public String findEmailById(@Param(value="id") Integer id);
	
	/**
	 * 查询ID
	 * @param email
	 * @return
	 */
	public Integer findIdByEmail(@Param(value="email") String email);
	
	/**
	 * 插入Admin
	 * @param admin
	 * @return
	 */
	public Integer insertAdmin(Admin admin);
	
}
