package com.example.Textile.Managment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Textile.Managment.dao.ResponseStructure;
import com.example.Textile.Managment.dao.UserDao;
import com.example.Textile.Managment.userdto.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User user2 = userDao.saveUser(user);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user2 != null) {
			responseStructure.setData(user2);
			responseStructure.setMessage("successfully saved");
			responseStructure.setStatus(HttpStatus.OK.value());
			ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;
		} else {
			responseStructure.setData(null);
			responseStructure.setMessage("entered improper id");
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
					responseStructure, HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
	}

	public ResponseEntity<ResponseStructure<User>> findById(int uid) {
		User user = userDao.findById(uid);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();

		if (user != null) {
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully found");
			ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			responseStructure.setData(null);
			responseStructure.setMessage("entered improper id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
					responseStructure, HttpStatus.NOT_FOUND);
			return responseEntity;

		}

	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteUserById(int id) {
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

	public ResponseEntity<ResponseStructure<User>> updateUser( int id ,User user) {
		User user2 = userDao.updateUser(id, user);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user2);
			ResponseEntity<ResponseStructure<User>> entity = new ResponseEntity<ResponseStructure<User>>(
					responseStructure, HttpStatus.OK);
			return entity;
		}
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("not found");
		responseStructure.setData(user2);
		ResponseEntity<ResponseStructure<User>> entity = new ResponseEntity<ResponseStructure<User>>(responseStructure,
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
