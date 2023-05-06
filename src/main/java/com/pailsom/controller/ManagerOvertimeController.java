package com.pailsom.controller;

import javax.servlet.http.HttpSession;

import com.pailsom.domain.Employee;
import com.pailsom.domain.OvertimeStatus;
import com.pailsom.repo.OvertimeRepo;
import com.pailsom.service.EmployeeService;
import com.pailsom.service.OvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerOvertimeController {

	
	@Autowired
	OvertimeRepo overtimeRepo;
	
	@Autowired
	OvertimeService overtimeService;
	
	@Autowired
	private EmployeeService empservice;
	
	@RequestMapping(value = "/manager")
	public String manager(Model model,HttpSession session) {
		//model.addAttribute("overtimeClaimList", overtimeService.findAll());
		
		int id =(int) session.getAttribute("userIdF");
		Employee e = empservice.findEmployeeById(id);
		model.addAttribute("employee",e);
		return "manager/ManagerWelcomePage";
	}
	
	@RequestMapping(value = "/overtimelist")
	public String list(Model model) {
		//model.addAttribute("overtimeClaimList", overtimeService.findAll());
		
		model.addAttribute("overtimeClaimList",overtimeService.findOvertimeByOvertimeStatus(OvertimeStatus.APPLIED));
		return "manager/ManagerOvertimeToApproveList";
	}

	@RequestMapping(value = "/overtimeApproved/{id}") //{id}
	public String approved(@PathVariable("id")Integer id, Model model) {
		
		boolean b = overtimeService.approvedOvertimeByManager(id);
		
		if(b == true) {
			overtimeService.calculateForCompensationLeave(id);
			model.addAttribute("approveflag",1);
		}else {
			model.addAttribute("approveflag",2);
		}
			return "forward:/overtimelist";
	}
	
	@RequestMapping(value = "/overtimeRejected/{id}") //{id}
	public String rejected(@PathVariable("id")Integer id, Model model) {
		
		boolean b = overtimeService.rejectedOvertimeByManager(id);
		
		if(b == true) {
			model.addAttribute("rejectflag",1);
		}else {
			model.addAttribute("rejectflag",2);
		}
			
			return "forward:/overtimelist";
	}
	
}