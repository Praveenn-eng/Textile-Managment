package com.example.Textile.Managment.userdto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	private String name;
	private long phno;
	private String email;
	private String pan;
	private String role;
	private double sal;

}
