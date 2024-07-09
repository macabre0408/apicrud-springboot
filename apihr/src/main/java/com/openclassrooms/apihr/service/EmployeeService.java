package com.openclassrooms.apihr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.apihr.model.Employee;
import com.openclassrooms.apihr.repository.EmployeeRepository;

import lombok.Data;

@Data
@Service
public class EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Optional<Employee> getEmployee(final Long Id){
		return employeeRepository.findById(Id);
	}
	
	public Iterable<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	public void deleteEmployee(final Long Id) throws Exception {
		if(employeeRepository.existsById(Id)) {
			employeeRepository.deleteById(Id);
		}
	}
	
	public Employee SaveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
