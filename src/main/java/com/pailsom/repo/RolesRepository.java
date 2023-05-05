package com.pailsom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pailsom.domain.RoleSecurity;



@Repository("roleRepository")
public interface RolesRepository extends JpaRepository<RoleSecurity, Long> {
	
	RoleSecurity findByRole(String role);
}
