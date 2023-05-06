package com.pailsom.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerEmailController {
	

	@RequestMapping("/newreq")
	public void newreq(HttpServletResponse response) throws IOException {


		response.sendRedirect("http://localhost:8080/leave/history");;
	}

}
