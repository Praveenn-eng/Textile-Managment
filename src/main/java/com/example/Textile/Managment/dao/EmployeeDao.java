package com.example.Textile.Managment.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Textile.Managment.Repository.EmployeeRepository;
import com.example.Textile.Managment.userdto.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee findById(int eid) {
		Optional<Employee> optional = employeeRepository.findById(eid);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public Employee updateEmployee(int eid, Employee employee) {
		Employee employee1 = findById(eid);
		if (employee1 != null) {
			return employeeRepository.save(employee);

		}
		return null;
	}

	public boolean deleteById(int eid) {
		Employee employee = findById(eid);
		if (employee != null) {
			employeeRepository.deleteById(eid);
			return true;
		}
		return false;
	}
}
