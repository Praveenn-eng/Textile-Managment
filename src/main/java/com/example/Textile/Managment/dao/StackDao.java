package com.example.Textile.Managment.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Textile.Managment.Repository.StackRepository;
import com.example.Textile.Managment.userdto.Stack;
import com.example.Textile.Managment.userdto.Vender;

@Repository
public class StackDao {

	@Autowired
	private StackRepository stackRepository;
	@Autowired
	private VenderDao venderDao;

	public Stack saveStackByVenderId(int vid, Stack stack) {
		Vender vender = venderDao.findById(vid);
		if (vender != null) {
			return stackRepository.save(stack);
		}
		return null;
	}
	public Stack findById(int sid) {
		Optional<Stack> optional = stackRepository.findById(sid);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	public Stack updateStack(int sid, Stack stack) {
		Stack stack2 = findById(sid);
		if (stack2 != null) {
			return stackRepository.save(stack);

		}

		return null;

	}

	public boolean deleteStack(int sid) {
		Stack stack = findById(sid);
		if (stack != null) {
			stackRepository.deleteById(sid);
			return true;

		}
		return false;

	}

}
