package com.pailsom.service;

import java.util.ArrayList;
import java.util.List;

import com.pailsom.domain.LeaveType;
import com.pailsom.repo.LeaveTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

	@Autowired
    LeaveTypeRepo ltrepo;

	@Override
	public ArrayList<LeaveType> findAll() {
		return (ArrayList<LeaveType>)ltrepo.findAll();
	}

	@Override
	public boolean saveLeaveType(LeaveType lt) {
		if (ltrepo.save(lt)!=null) return true; else return false;
	}

	@Override
	public void deleteLeaveType(LeaveType lt) {
		ltrepo.delete(lt);
	}

	@Override
	public LeaveType findLeaveTypeById(Integer id) {
		return ltrepo.findById(id).get();
	}

	@Override
	public List<String> findAllLeaveTypeNameByEmpId(Integer id) {
		return ltrepo.findAllLeaveTypeNameByEmpId(id);
	}

	@Override
	public LeaveType findLeaveTypeIdBySaw(Integer id, String name) {
		return ltrepo.findLeaveTypeIdBySaw(id, name);
	}

	
	
}
