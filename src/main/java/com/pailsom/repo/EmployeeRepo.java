package com.pailsom.repo;

import java.util.List;

import com.pailsom.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("erepo")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	public List<Employee> findAllEmployeesByName(String name);
}
