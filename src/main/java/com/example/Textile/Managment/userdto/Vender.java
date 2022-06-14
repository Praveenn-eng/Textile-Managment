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
public class Vender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vid;
	private String materialName;
	private double quantity;
	private double unticost;
	private String name;
	private long phno;
	private String email;

	@OneToMany
	private List<Stack> stack;

}
