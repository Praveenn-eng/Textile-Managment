package com.example.Textile.Managment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Textile.Managment.userdto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
