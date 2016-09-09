package com.dms.kit;

import com.dms.entity.Admin;

/**
 * 保存当前用户,自动释放资源
 * 
 * @author zhao
 *
 */
public class AdminKit implements AutoCloseable {

	private static final ThreadLocal<Admin> current = new ThreadLocal<Admin>();

	public AdminKit(Admin admin) {
		current.set(admin);
	}

	public static Admin getCurrentAdmin() {
		return current.get();
	}

	public static void remove() {
		current.remove();
	}

	public void close() {
		current.remove();
	}
}
