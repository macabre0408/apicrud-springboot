package com.openclassrooms.apihr.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.apihr.model.Employee;
import com.openclassrooms.apihr.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees(){
		return employeeService.getAllEmployee();
	}
	
	@PostMapping("/create/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.SaveEmployee(employee);
	}
	
	@DeleteMapping("employee/{id}")
	public void DeleteEmployee(@PathVariable("id") final Long Id) throws Exception {
		employeeService.deleteEmployee(Id);
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") final Long Id){
		return employeeService.getEmployee(Id);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") final Long Id, @RequestBody Employee employee) {
		Optional<Employee> e = employeeService.getEmployee(Id);
		if(e.isPresent()) {
			Employee currentEmployee = e.get();
			
			if(employee.getFirstName()!=null) {
				currentEmployee.setFirstName(employee.getFirstName());
			}
			if(employee.getLastName()!=null) {
				currentEmployee.setLastName(employee.getLastName());
			}
			if(employee.getMail()!=null) {
				currentEmployee.setMail(employee.getMail());
			}
			if(employee.getPassword()!=null) {
				currentEmployee.setPassword(employee.getPassword());
			}
			employeeService.SaveEmployee(currentEmployee);	
			return currentEmployee;
		}
		else {
			return null;
		}
	}
}
