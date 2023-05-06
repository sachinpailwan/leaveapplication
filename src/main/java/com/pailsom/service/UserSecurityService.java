package com.pailsom.service;

import java.util.List;

import com.pailsom.domain.RoleSecurity;
import com.pailsom.domain.UserSecurity;

public interface UserSecurityService {
	
	public UserSecurity findUserByEmail(String email);
	
	public void saveAdminUser(UserSecurity user);
	
	public void saveStaffUser(UserSecurity user);
	
	public void saveManagerUser(UserSecurity user);
	
	public void saveRole(RoleSecurity role);
	
	public int findRoleIdSecurityByUserId(Integer id);
	
	public List<String> findEmail();
}