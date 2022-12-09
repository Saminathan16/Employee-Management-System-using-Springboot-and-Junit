package com.sam.springjpa.service;

import com.sam.springjpa.entity.Employee;

public interface EmployeeService {

	Iterable<Employee> readAll();

	Employee store(Employee emp);

	void remove(Long id);

	Employee update(Long id,String fn);


}
