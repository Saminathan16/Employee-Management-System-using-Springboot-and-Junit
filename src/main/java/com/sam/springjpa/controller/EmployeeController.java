package com.sam.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.springjpa.entity.Employee;
import com.sam.springjpa.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService emps;

	@GetMapping
	public Iterable<Employee> getEmployee() {
		return emps.readAll();
	}

	@PostMapping
	public Employee setEmployees(@RequestBody Employee emp) {
		return emps.store(emp);

	}

	@PutMapping(value = "/{id}")
	public Employee updateEmployees(@PathVariable Long id,@RequestBody String fn) {
		return emps.update(id,fn);

	}

	@DeleteMapping(value = "/{id}")
	public String deleteEmployees(@PathVariable Long id) {
		emps.remove(id);
		return "deleted - " + id;

	}

}
