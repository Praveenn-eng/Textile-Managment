package com.example.Textile.Managment.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Textile.Managment.Repository.UserRepository;
import com.example.Textile.Managment.userdto.Customer;
import com.example.Textile.Managment.userdto.User;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);

	}

	public User findById(int uid) {
		Optional<User> optional = userRepository.findById(uid);
		if (optional.isEmpty()) {
			return null;

		}

		return optional.get();

	}

	public User updateUser(int uid, User user) {
		User user1 = findById(uid);
		if (user1 != null) {
			return userRepository.save(user);

		}
		return null;

	}

	public boolean deleteById(int uid) {
		User user = findById(uid);
		if (user != null) {
			userRepository.deleteById(uid);
			return true;

		}
		return false;

	}

}
