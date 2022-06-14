package com.example.Textile.Managment.userdto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Stack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name_of_vender;
	private String material_Name;
	private double quantity;
	private String vender_email;
	private long vender_phno;
	private double unitcost;
	@ManyToOne
	private Vender vender;
	@ManyToOne
	private Customer customer;
	
	
}
