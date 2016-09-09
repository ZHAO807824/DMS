package com.dms.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dms.dao.IAdminDao;
import com.dms.entity.Admin;
import com.dms.util.AuthUtil;
import com.dms.util.MD5Util;

/**
 * 
 * @author zhao
 *
 */
@Service
public class AdminService implements IAdminService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private IAdminDao adminDao;

	public Admin login(String email, String password) {
		try {
			return adminDao.findOne(email, MD5Util.getMD5(password));
		} catch (Exception e) {
			LOGGER.info("AdminService login(String,String)," + e.getMessage());
		}
		return null;
	}

	public boolean check(String value) {
		if (StringUtils.isNotEmpty(value)) {
			String[] values = value.split(":");

			Long time = Long.valueOf(values[1]);

			if (time > System.currentTimeMillis()) {
				return false;
			}
			String email = null;
			try {
				email = adminDao.findEmailById(Integer.valueOf(values[0]));
			} catch (Exception e) {
				LOGGER.info("AdminService check(String)," + e.getMessage());
				return false;
			}

			if (StringUtils.isNotEmpty(email)) {
				if (values[2].equals(AuthUtil.getMD5(email))) {
					return true;
				}
			}
		}
		return false;
	}

}
