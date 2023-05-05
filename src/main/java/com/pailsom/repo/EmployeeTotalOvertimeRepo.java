package com.pailsom.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pailsom.domain.EmployeeTotalOvertime;

public interface EmployeeTotalOvertimeRepo extends JpaRepository<EmployeeTotalOvertime, Integer>{

	public EmployeeTotalOvertime findByEmployeeId(Integer id);
}
