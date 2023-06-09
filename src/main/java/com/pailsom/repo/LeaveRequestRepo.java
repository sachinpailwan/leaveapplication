package com.pailsom.repo;

import java.util.ArrayList;
import java.util.List;

import com.pailsom.domain.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pailsom.domain.LeaveStatus;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, Integer> {

	@Query("Select lr from LeaveRequest lr, LeaveType lt where lr.leaveType = lt and lt.id = :id")
	List<LeaveRequest> findLeaveByLeaveTypeId(@Param("id") Integer id);
	
	public ArrayList<LeaveRequest> findByLeaveStatus(LeaveStatus ls);
	 
	public List<LeaveRequest> findLeaveRequestByEmployeeId(Integer id);
}
