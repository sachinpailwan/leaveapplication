package com.pailsom.service;

import java.util.ArrayList;
import java.util.List;

import com.pailsom.domain.LeaveType;

public interface LeaveTypeService {
	
	public ArrayList<LeaveType> findAll();
	public boolean saveLeaveType(LeaveType lt);
	public void deleteLeaveType(LeaveType lt);
	public LeaveType findLeaveTypeById(Integer id);
	public List<String> findAllLeaveTypeNameByEmpId(Integer id);
	public LeaveType findLeaveTypeIdBySaw(Integer id,String name);
}
