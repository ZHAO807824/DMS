package com.dms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.dao.IAdminDao;
import com.dms.entity.Admin;
import com.dms.util.MD5Util;

/**
 * 
 * @author zhao
 *
 */
@Service
public class AdminService implements IAdminService {
	private static final Logger LOGGER=LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private IAdminDao adminDao;

	public Admin login(String email,String password) {
		try {
			return adminDao.findOne(email,MD5Util.getMD5(password));
		} catch (Exception e) {
			LOGGER.info("AdminService login(String,String),"+e.getMessage());
		}
		return null;
	}

}
