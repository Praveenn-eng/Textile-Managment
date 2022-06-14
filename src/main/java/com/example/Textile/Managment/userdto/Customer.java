package com.example.Textile.Managment.userdto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String name;
	private long phno;
	private String email;
	private String material_name;
	private double quantity;
	private double amount;

	@OneToMany
	private List<Stack> stacks;

}
