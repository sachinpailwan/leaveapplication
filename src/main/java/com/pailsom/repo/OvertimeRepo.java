package com.pailsom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pailsom.domain.Overtime;
import com.pailsom.domain.OvertimeStatus;

public interface OvertimeRepo extends JpaRepository<Overtime, Integer> {
	public List<Overtime> findOvertimeByOvertimeStatus(OvertimeStatus os);
	
	public List<Overtime> findOvertimeByEmployeeId(Integer id);
}
