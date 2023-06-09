package com.pailsom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pailsom.domain.Overtime;
import com.pailsom.domain.OvertimeStatus;

@Service
public interface OvertimeService {

	public ArrayList<Overtime> findAll();
	public boolean applyOver(Overtime over);
	public boolean updateOver(Overtime over);
	public void cancelOver(Overtime over);
	public boolean saveOver(Overtime over);
	public Overtime findOverById(Integer id);
	
	public boolean approvedOvertimeByManager(Integer id);

	public boolean rejectedOvertimeByManager(Integer id);
	
	
	
	public List<Overtime> findOvertimeByOvertimeStatus(OvertimeStatus os);
	
	public boolean calculateForCompensationLeave(Integer id);
	public List<Overtime> findOvertimeByEmployeeId(Integer id);
}
