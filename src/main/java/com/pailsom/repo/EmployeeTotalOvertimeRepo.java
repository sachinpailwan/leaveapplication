package com.pailsom.repo;

import com.pailsom.domain.EmployeeTotalOvertime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTotalOvertimeRepo extends JpaRepository<EmployeeTotalOvertime, Integer>{

	public EmployeeTotalOvertime findByEmployeeId(Integer id);
}
