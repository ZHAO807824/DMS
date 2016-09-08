package com.dms.dao;

import org.apache.ibatis.annotations.Param;

import com.dms.entity.Admin;

/**
 * 
 * @author zhao
 *
 */
public interface IAdminDao {

	/*
	 * 查询
	 */
	public Admin findOne(@Param(value = "email") String email,@Param(value = "password") String password);
}
