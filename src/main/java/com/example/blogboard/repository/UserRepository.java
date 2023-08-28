package com.example.blogboard.repository;


import com.example.blogboard.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

	//Users findByUsername(String username);
	Optional<Users> findByUsername(String username);
}
