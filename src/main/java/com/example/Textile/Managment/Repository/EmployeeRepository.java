package com.example.Textile.Managment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Textile.Managment.userdto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
