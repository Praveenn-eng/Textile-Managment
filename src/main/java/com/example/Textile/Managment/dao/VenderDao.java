package com.example.Textile.Managment.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Textile.Managment.Repository.VenderRepository;
import com.example.Textile.Managment.userdto.Vender;

@Repository
public class VenderDao {

	@Autowired
	private VenderRepository venderRepository;

	public Vender saveVender(Vender vender) {

		return venderRepository.save(vender);

	}

	public Vender findById(int vid) {
		Optional<Vender> optional = venderRepository.findById(vid);
		if (optional.isEmpty()) {
			return null;

		}
		return optional.get();

	}

	public Vender updateVender(int vid, Vender vender) {
		Vender vender2 = findById(vid);
		if (vender2 != null) {
			return venderRepository.save(vender);

		}
		return null;

	}

	public boolean deleteById(int vid) {
		Vender vender = findById(vid);
		if (vender != null) {
			venderRepository.deleteById(vid);
			return true;

		}
		return false;

	}

}
