package com.dms.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.IAdminDao;
import com.dms.dao.user.IUserDao;
import com.dms.entity.Admin;
import com.dms.entity.user.User;
import com.dms.entity.user.UserAdmin;
import com.dms.util.AuthUtil;
import com.dms.util.MD5Util;
import com.dms.util.ValidatorUtil;

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

	@Autowired
	private IUserDao userDao;

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

			if (time > System.currentTimeMillis())
				return false;

			String email = null;
			try {
				email = adminDao.findEmailById(Integer.valueOf(values[0]));
			} catch (Exception e) {
				LOGGER.info("AdminService check(String)," + e.getMessage());
				return false;
			}

			if (StringUtils.isNotEmpty(email))
				if (values[2].equals(AuthUtil.getMD5(email)))
					return true;

		}
		return false;
	}

	public boolean checkEmail(String email) {
		if (StringUtils.isNotEmpty(email) && ValidatorUtil.isEmail(email)) {
			try {
				Integer id = adminDao.findIdByEmail(email);
				return id != null ? true : false;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	/**
	 * 使用Spring的注解事务,要么不用try catch 要么就在catch中抛出异常,否则在catch后不会进行事务回滚
	 * 
	 * throws RuntimeException:运行时异常,手动抛出Exception异常事务无效
	 */
	@Transactional
	public boolean register(Admin admin, User user) throws RuntimeException {
		try {
			adminDao.insertAdmin(admin);
			Integer adminId = admin.getId();
			userDao.insertUser(user);
			Integer userId = user.getId();
			if (adminId != null && userId != null) {
				UserAdmin userAdmin = new UserAdmin(userId, adminId);
				userDao.insertUserAdmin(userAdmin);
				if (userAdmin != null) {
					return true;
				}
			}
			throw new RuntimeException("AdminService register(Admin,User) Error:adminId=null||userId=null");
		} catch (Exception e) {
			LOGGER.info("AdminService register(Admin,User)," + e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

}
