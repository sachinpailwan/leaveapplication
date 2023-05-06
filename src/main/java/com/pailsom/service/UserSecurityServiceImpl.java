package com.pailsom.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.pailsom.domain.RoleSecurity;
import com.pailsom.domain.UserSecurity;
import com.pailsom.repo.RolesRepository;
import com.pailsom.repo.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService") //business logic
public class UserSecurityServiceImpl implements UserSecurityService{

	@Autowired
	private UserSecurityRepository userRepository;
	
	@Autowired
	private RolesRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserSecurity findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveAdminUser(UserSecurity user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		RoleSecurity userRole= roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<RoleSecurity>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
	@Override
	public void saveStaffUser(UserSecurity user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		RoleSecurity userRole= roleRepository.findByRole("STAFF");
		user.setRoles(new HashSet<RoleSecurity>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
	@Override
	public void saveManagerUser(UserSecurity user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		RoleSecurity userRole= roleRepository.findByRole("MANAGER");
		user.setRoles(new HashSet<RoleSecurity>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
	
	@Override
	public void saveRole(RoleSecurity role) {
		roleRepository.save(role);
	}

	@Override
	public int findRoleIdSecurityByUserId(Integer id) {
		return userRepository.findRoleIdSecurityByUserId(id);
	}

	@Override
	public List<String> findEmail() {
		return userRepository.findAllEmails();
	}

}
