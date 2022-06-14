package com.example.Textile.Managment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Textile.Managment.dao.EmployeeDao;
import com.example.Textile.Managment.dao.ResponseStructure;
import com.example.Textile.Managment.dao.UserDao;
import com.example.Textile.Managment.userdto.Employee;
import com.example.Textile.Managment.userdto.User;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao userDao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee user) {
		Employee user2 = userDao.saveEmployee(user);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setData(user2);
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.OK.value());

		ResponseEntity<ResponseStructure<Employee>> responseEntity = new ResponseEntity<ResponseStructure<Employee>>(
				responseStructure, HttpStatus.OK);

		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<Employee>> findByIdEmployee(int eid) {
		Employee user = userDao.findById(eid);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();

		if (user != null) {
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully found");
			ResponseEntity<ResponseStructure<Employee>> responseEntity = new ResponseEntity<ResponseStructure<Employee>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			responseStructure.setData(null);
			responseStructure.setMessage("entered improper id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			ResponseEntity<ResponseStructure<Employee>> responseEntity = new ResponseEntity<ResponseStructure<Employee>>(
					responseStructure, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}
	public ResponseEntity<ResponseStructure<Boolean>> deleteEmployeeById(int id) {
		ResponseStructure<Boolean> responseStructure = new ResponseStructure<Boolean>();
		boolean status = userDao.deleteById(id);
		if (status) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(status);
			ResponseEntity<ResponseStructure<Boolean>> entity = new ResponseEntity<ResponseStructure<Boolean>>(
					responseStructure, HttpStatus.OK);
			return entity;
		}
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("not found");
		responseStructure.setData(status);
		ResponseEntity<ResponseStructure<Boolean>> entity = new ResponseEntity<ResponseStructure<Boolean>>(
				responseStructure, HttpStatus.NOT_FOUND);
		return entity;
	}

	public ResponseEntity<ResponseStructure<Employee>> updateUser( int id ,Employee user) {
		Employee user2 = userDao.updateEmployee(id, user);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user2);
			ResponseEntity<ResponseStructure<Employee>> entity = new ResponseEntity<ResponseStructure<Employee>>(
					responseStructure, HttpStatus.OK);
			return entity;
		}
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("not found");
		responseStructure.setData(user2);
		ResponseEntity<ResponseStructure<Employee>> entity = new ResponseEntity<ResponseStructure<Employee>>(responseStructure,
				HttpStatus.NOT_FOUND);
		return entity;
	}

	/**
	 * public ResponseEntity<ResponseStructure<User>> getAllUser() { List<User>
	 * users = userDao.getAll(); ResponseStructure<List<User>> responseStructure =
	 * new ResponseStructure<List<User>>(); if (users != null) {
	 * responseStructure.setStatus(HttpStatus.OK.value());
	 * responseStructure.setMessage("success"); responseStructure.setData(users);
	 * ResponseEntity<ResponseStructure<User>> entity = new
	 * ResponseEntity<ResponseStructure<User>>(HttpStatus.OK); return entity; }
	 * responseStructure.setStatus(HttpStatus.OK.value());
	 * responseStructure.setMessage("not found"); responseStructure.setData(users);
	 * ResponseEntity<ResponseStructure<User>> entity = new
	 * ResponseEntity<ResponseStructure<User>>(HttpStatus.NOT_FOUND); return entity;
	 * }
	 **/
	
}

