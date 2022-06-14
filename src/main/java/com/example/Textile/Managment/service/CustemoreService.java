package com.example.Textile.Managment.service;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Textile.Managment.dao.CustomerDao;
import com.example.Textile.Managment.dao.ResponseStructure;
import com.example.Textile.Managment.userdto.Customer;
import com.example.Textile.Managment.userdto.Employee;
import com.example.Textile.Managment.userdto.Stack;

public class CustemoreService {

	public CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer, Stack stack) {
		Customer customer2 = customerDao.saveCustomer(stack, customer);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		responseStructure.setData(customer2);
		responseStructure.setMessage("Customer saved Sucessfuly");
		responseStructure.setStatus(HttpStatus.OK.value());

		ResponseEntity<ResponseStructure<Customer>> entity = new ResponseEntity<ResponseStructure<Customer>>(
				responseStructure, HttpStatus.OK);

		return entity;

	}

//	 Find id by Customer
	public ResponseEntity<ResponseStructure<Customer>> findByIdCustomer(int eid) {
		Customer customer = customerDao.findById(eid);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();

		if (customer != null) {
			responseStructure.setData(customer);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully found");
			ResponseEntity<ResponseStructure<Customer>> responseEntity = new ResponseEntity<ResponseStructure<Customer>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			responseStructure.setData(null);
			responseStructure.setMessage("entered improper id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			ResponseEntity<ResponseStructure<Customer>> responseEntity = new ResponseEntity<ResponseStructure<Customer>>(
					responseStructure, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteCustomerById(int id) {
		ResponseStructure<Boolean> responseStructure = new ResponseStructure<Boolean>();
		boolean status = customerDao.deleteById(id);
		if (status) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Customer Deleted Sucessfuly");
			responseStructure.setData(status);
			ResponseEntity<ResponseStructure<Boolean>> entity = new ResponseEntity<ResponseStructure<Boolean>>(
					responseStructure, HttpStatus.OK);
			return entity;
		}
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Id Not Found");
		responseStructure.setData(status);
		ResponseEntity<ResponseStructure<Boolean>> entity = new ResponseEntity<ResponseStructure<Boolean>>(
				responseStructure, HttpStatus.NOT_FOUND);
		return entity;
	}

	public ResponseEntity<ResponseStructure<Customer>> updateUser(int id, Customer customer) {
		Customer user2 = customerDao.updateCustomer(id, customer);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<Customer>();
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user2);
			ResponseEntity<ResponseStructure<Customer>> entity = new ResponseEntity<ResponseStructure<Customer>>(
					responseStructure, HttpStatus.OK);
			return entity;
		}
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("not found");
		responseStructure.setData(user2);
		ResponseEntity<ResponseStructure<Customer>> entity = new ResponseEntity<ResponseStructure<Customer>>(
				responseStructure, HttpStatus.NOT_FOUND);
		return entity;
	}

}
