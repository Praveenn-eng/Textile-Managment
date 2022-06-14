package com.example.Textile.Managment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Textile.Managment.userdto.Customer;
import com.example.Textile.Managment.userdto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
