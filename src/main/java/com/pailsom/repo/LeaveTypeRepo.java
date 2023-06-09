package com.pailsom.repo;

import java.util.List;

import com.pailsom.domain.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LeaveTypeRepo extends JpaRepository<LeaveType, Integer> {

	
	public List<LeaveType> findAllLeaveTypeByEmployeeId(Integer id);
	
	@Query(value = "Select leave_type_name from leave_type where employee_id = :id",nativeQuery = true)
	public List<String> findAllLeaveTypeNameByEmpId(int id);
	

	@Query(value = "Select * from leave_type where employee_id = :id and leave_type_name = :name",nativeQuery = true)
	public LeaveType findLeaveTypeIdBySaw(Integer id, String name);
}
