package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

	User findByEmailId(String emailId);

	Optional<User> findById(Long userId);

	void deleteById(Long userId);

	  

	User findByEmailIdAndPassword(String emailId, String password);
}