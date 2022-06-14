package com.example.Textile.Managment.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Textile.Managment.dao.ResponseStructure;
import com.example.Textile.Managment.dao.VenderDao;
import com.example.Textile.Managment.userdto.Employee;
import com.example.Textile.Managment.userdto.Vender;

public class Venderservice {

	VenderDao dao;

	public ResponseEntity<ResponseStructure<Vender>> saveVender(Vender vender) {
		Vender user2 = dao.saveVender(vender);
		ResponseStructure<Vender> responseStructure = new ResponseStructure<Vender>();
		responseStructure.setData(user2);
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.OK.value());

		ResponseEntity<ResponseStructure<Vender>> responseEntity = new ResponseEntity<ResponseStructure<Vender>>(
				responseStructure, HttpStatus.OK);

		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<Vender>> findbyIdVender(int eid) {
		Vender user = dao.findById(eid);
		ResponseStructure<Vender> responseStructure = new ResponseStructure<Vender>();

		if (user != null) {
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully found");
			ResponseEntity<ResponseStructure<Vender>> responseEntity = new ResponseEntity<ResponseStructure<Vender>>(
					responseStructure, HttpStatus.OK);

		} else {
			responseStructure.setData(null);
			responseStructure.setMessage("entered improper id");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			ResponseEntity<ResponseStructure<Vender>> responseEntity = new ResponseEntity<ResponseStructure<Vender>>(
					responseStructure, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteVenderById(int id) {
		ResponseStructure<Boolean> responseStructure = new ResponseStructure<Boolean>();
		boolean status = dao.deleteById(id);
		if (status) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(status);
			ResponseEntity<ResponseStructure<Boolean>> entity = new ResponseEntity<ResponseStructure<Boolean>>(
					responseStructure, HttpStatus.OK);
			return entity;
		}
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("not found");
		responseStructure.setData(status);
		ResponseEntity<ResponseStructure<Boolean>> entity = new ResponseEntity<ResponseStructure<Boolean>>(
				responseStructure, HttpStatus.NOT_FOUND);
		return entity;
	}

	public ResponseEntity<ResponseStructure<Vender>> updateUser(int id, Vender vender) {
		Vender user2 = dao.updateVender(id, vender);
		ResponseStructure<Vender> responseStructure = new ResponseStructure<Vender>();
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(user2);
			ResponseEntity<ResponseStructure<Vender>> entity = new ResponseEntity<ResponseStructure<Vender>>(
					responseStructure, HttpStatus.OK);
			return entity;
		}
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("not found");
		responseStructure.setData(user2);
		ResponseEntity<ResponseStructure<Vender>> entity = new ResponseEntity<ResponseStructure<Vender>>(
				responseStructure, HttpStatus.NOT_FOUND);
		return entity;
	}

}
