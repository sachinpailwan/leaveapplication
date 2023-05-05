package com.pailsom.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pailsom.domain.Employee;

@Repository("erepo")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	public List<Employee> findAllEmployeesByName(String name);
}
