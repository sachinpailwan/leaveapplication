package com.pailsom.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.pailsom.domain.Employee;
import com.pailsom.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    EmployeeRepo erepo;
	
	@Override
	public ArrayList<Employee> findAll() {
		return (ArrayList<Employee>)erepo.findAll();
	}

	@Override
	public void saveEmployee(Employee emp) {
		erepo.save(emp);
	}
	
	@Override
	public Employee findEmployeeById(Integer id) {
		return erepo.findById(id).get();
	}

	@Override
	public void deleteEmployee(Integer id) {
		erepo.deleteById(id);
	}



	@Override
	public ArrayList<String> findAllEmployeeNames(String name) {
		ArrayList<String> names = new ArrayList<String>();
		List<Employee> emplist = erepo.findAllEmployeesByName(name);
		for (Iterator<Employee> iterator = emplist.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			names.add(employee.getName());
		}
		return names;
	}

}