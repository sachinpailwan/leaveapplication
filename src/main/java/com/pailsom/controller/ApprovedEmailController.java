package com.pailsom.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.pailsom.domain.Employee;
import com.pailsom.domain.LeaveRequest;
import com.pailsom.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApprovedEmailController {
	@Autowired
	private LeaveRequestService lrs;
	

	@RequestMapping(value="/approve/{id}")
	public void approve(@PathVariable("id") Integer id,HttpServletResponse response) throws IOException {
		
		LeaveRequest l = lrs.findLeaveById(id);
		Employee emp = l.getEmployee();
		response.sendRedirect("http://localhost:8080/pendingLeavelist");
	}
}
