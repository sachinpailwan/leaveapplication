package com.pailsom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pailsom.domain.UserSecurity;


@Repository("userRepository")
public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {
	
	UserSecurity findByEmail(String email);
	
	@Query(value = "Select role_id from user_role where user_id = :id",nativeQuery = true)
	int findRoleIdSecurityByUserId(Integer id);

	@Query(value = "Select email from user",nativeQuery = true)
	List<String> findAllEmails();
}
