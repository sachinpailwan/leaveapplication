package com.pailsom.repo;

import com.pailsom.domain.RoleSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("roleRepository")
public interface RolesRepository extends JpaRepository<RoleSecurity, Long> {
	
	RoleSecurity findByRole(String role);
}
