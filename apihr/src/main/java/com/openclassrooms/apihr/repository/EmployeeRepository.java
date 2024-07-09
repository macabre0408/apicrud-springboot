package com.openclassrooms.apihr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.apihr.model.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
