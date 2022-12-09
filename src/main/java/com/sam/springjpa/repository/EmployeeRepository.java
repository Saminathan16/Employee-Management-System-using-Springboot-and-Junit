package com.sam.springjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.sam.springjpa.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
}
