package com.example.Textile.Managment.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Textile.Managment.Repository.CustomerRepository;
import com.example.Textile.Managment.Repository.StackRepository;
import com.example.Textile.Managment.userdto.Customer;
import com.example.Textile.Managment.userdto.Stack;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private StackRepository stackRepository;

	public Customer saveCustomer(Stack stack, Customer customer) {
		Stack stack2 = stackRepository.save(stack);    // here stack id need to send with body
		return customerRepository.save(customer);
	}

	public Customer findById(int cid) {
		Optional<Customer> optional = customerRepository.findById(cid);
		if (optional.isEmpty()) {
			return null;

		}
		return optional.get();

	}

	public Customer updateCustomer(int cid, Customer customer) {
		Customer customer2 = findById(cid);
		if (customer2 != null) {
			return customerRepository.save(customer);

		}
		return null;

	}

	public boolean deleteById(int cid) {
		Customer customer = findById(cid);
		if (customer != null) {
			customerRepository.deleteById(cid);
			return true;

		}
		return false;

	}

}
