package com.dms.dao.user;

import org.springframework.stereotype.Repository;

import com.dms.entity.user.User;
import com.dms.entity.user.UserAdmin;

/**
 * 
 * @author zhao
 *
 */
@Repository("userDao")
public interface IUserDao {

	/**
	 * 插入User
	 * @param user
	 * @return
	 */
	public Integer insertUser(User user);
	
	/**
	 * 插入user_admin
	 * @param userId
	 * @param adminId
	 */
	public Integer insertUserAdmin(UserAdmin userAdmin);
	
}
