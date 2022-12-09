package com.sam.springjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.springjpa.entity.Employee;
import com.sam.springjpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository empr;
	
	@Override
	public Iterable<Employee> readAll() {
		// TODO Auto-generated method stub
		Iterable<Employee> res=empr.findAll();
		System.out.println("getting data from db: "+res);
		return res;
	}
	
	@Override
	public Employee store(Employee emp) {
		// TODO Auto-generated method stub
		Employee res=empr.save(emp);
		return res;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub	
		 empr.deleteById(id);
		
	}

	@Override
	public Employee update(Long id,String fn) {
		// TODO Auto-generated method stub
		Employee em=empr.findById(id).get();
		em.setFirstName(fn);
		Employee res=empr.save(em);
		System.out.println("updating data from db: "+res);
		return res;
	}
	
}
