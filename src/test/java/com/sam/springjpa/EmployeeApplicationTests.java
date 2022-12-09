package com.sam.springjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sam.springjpa.controller.EmployeeController;
import com.sam.springjpa.entity.Employee;
import com.sam.springjpa.repository.EmployeeRepository;
import com.sam.springjpa.service.EmployeeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EmployeeApplicationTests {
	
	@MockBean
	EmployeeService service;
	
	@Autowired
	EmployeeController empc;
	
	Employee emp=new Employee();
	
	@BeforeEach
	public void setUp()
	{
		emp.setEmpId(101L);
		emp.setFirstName("Sam");
		emp.setLastName("kumar");
		emp.setAge(22);
		emp.setSalary(1000d);
	}
	
	@DisplayName("Get Employee Test")
	@Test
	public void getEmployeeTest()
	{
		
		when(service.readAll()).thenReturn(Stream.of(emp).collect(Collectors.toList()));
		assertEquals(1, ((List<Employee>) empc.getEmployee()).size());
	}
	
	@DisplayName("Save Employee Test")
	@Test
	public void saveEmployeeTest()
	{
		when(service.store(emp)).thenReturn(emp);
		assertEquals(emp, empc.setEmployees(emp));
	}
	
	@DisplayName("Update Employee Test")
	@Test
	public void updateEmployeeTest()
	{
		long empid=101L;
		String firstname="saminathan";
		//System.out.println(emp);
		when(service.update(empid,firstname)).thenReturn(emp);
		assertEquals(emp, empc.updateEmployees(empid,firstname));
	}
	
	@DisplayName("delete Employee Test")
	@Test
	public void deleteEmployeeTest()
	{
		long empid=101;
		empc.deleteEmployees(empid);
		verify(service,times(1)).remove(empid);
	}
	
//	@DisplayName("read employees")
//	@Test
//	void readEmployees() {
//		Employee emp=new Employee();
//		emp.setEmpId(101L);
//		emp.setFirstName("sami");
//		emp.setLastName("nathan");
//		emp.setAge(21);
//		emp.setSalary(2500d);
//		List<Employee> emp1=new ArrayList<Employee>();
//		emp1.add(emp);
//		Mockito.when(repo.findAll()).thenReturn(emp1);
//		
//		Iterable<Employee> e1=emps.readAll();
//		assertNotNull(e1);
//		
//		
//		//repo.findAll().forEach(e->{
//		//System.out.println(e.getFirstName());
//		//});
//		
//		//emp.setAge(22);
//		//repo.save(emp);
//		
//		//Optional<Employee> e2=repo.findById(101L);
//		//System.out.println(e2);
//		
//		//repo.delete(emp);
//		
//		//Optional<Employee> e3=repo.findById(101L);
//		//System.out.println(e3);
//	}
}
