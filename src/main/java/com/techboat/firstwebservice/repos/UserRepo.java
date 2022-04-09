package com.techboat.firstwebservice.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techboat.firstwebservice.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{
	Optional<User> findByName(String name);

}
