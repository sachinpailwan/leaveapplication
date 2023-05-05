package com.pailsom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.pailsom.domain.Employee;
import com.pailsom.domain.Gender;
import com.pailsom.domain.LeaveRequest;
import com.pailsom.domain.LeaveStatus;
import com.pailsom.domain.LeaveType;
import com.pailsom.domain.Role;
import com.pailsom.domain.RoleSecurity;
import com.pailsom.domain.UserSecurity;
import com.pailsom.repo.EmployeeRepo;
import com.pailsom.repo.LeaveRequestRepo;
import com.pailsom.repo.LeaveTypeRepo;
import com.pailsom.service.UserSecurityService;
@SpringBootApplication
public class LeaveApplication implements CommandLineRunner{
	@Autowired
	EmployeeRepo erepo;
	@Autowired
	LeaveRequestRepo lrrepo;
	@Autowired
	LeaveTypeRepo ltrepo;

	
	@Autowired
	 private UserSecurityService userService;

	/*
	 * @Autowired UserRepo urepo;
	 */

	public static void main(String[] args) {
		SpringApplication.run(LeaveApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Admincreate - Store to db
		RoleSecurity role = new RoleSecurity();
		role.setId(1);
		role.setRole("ADMIN");
		userService.saveRole(role);
		
		role = new RoleSecurity();
		role.setId(2);
		role.setRole("STAFF");
		userService.saveRole(role);
		
		role = new RoleSecurity();
		role.setId(3);
		role.setRole("MANAGER");
		userService.saveRole(role);
		
		UserSecurity user = new UserSecurity();	
		user.setId(1);
		user.setEmail("admin@gmail.com");
		user.setPassword("abc123");
		user.setFirstname("Admin");
		user.setLastname("Admin");
		userService.saveAdminUser(user);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String d0 = "2014-02-11";
			Date dob = sdf.parse(d0);
			
			String d1 = "2017-02-11";
			Date s1 = sdf.parse(d1);
			String d2 = "2020-06-11";
			Date end1 = sdf.parse(d2);
			//create Employee object
			Employee e1 = new Employee ("Summer","summer@gmail.com","Vivaldi", Role.ADMIN,Gender.FEMALE,dob,s1,end1);
			erepo.save(e1);
			String d3 = "2019-05-11";
			Date leavestart1 = sdf.parse(d3);
			String d4 = "2019-05-15";
			Date leaveend1 = sdf.parse(d4);
			
			Employee e2 = new Employee ("Saw","saw@gmail.com","Vivaldi", Role.ADMIN,Gender.MALE,dob,s1,end1);
			erepo.save(e2);
			Employee e3 = new Employee ("KyawThiha","Kyaw@gmail.com","Vivaldi",Role.ADMIN,Gender.MALE,dob,s1,end1);
			erepo.save(e3);
			Employee e4 = new Employee ("Lance","Lance@gmail.com","Vivaldi",Role.MANAGER,Gender.MALE,dob,s1,end1);
			erepo.save(e4);
			
			//create LeaveType object
			
			LeaveType lt1 = new LeaveType("Annual Leave",18,9,e1);
			ltrepo.save(lt1);
			LeaveType lt2 = new LeaveType("Medical Leave",60,40,e2);
			ltrepo.save(lt2);
			
			
			//create LeaveRequest Object
			
			LeaveRequest lr1 = new LeaveRequest(leavestart1,leaveend1,5,"Annual Leave"," ",LeaveStatus.APPLIED,e1,lt1);
			lrrepo.save(lr1);
			LeaveRequest lr2 = new LeaveRequest(leavestart1,leaveend1,5,"Medical Leave"," ",LeaveStatus.APPLIED,e2,lt2);
			lrrepo.save(lr2);
			
		};
	}
	
}




