package com.infy.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.instagram.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByUsername(String username);
}
