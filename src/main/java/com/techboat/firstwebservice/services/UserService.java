package com.techboat.firstwebservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techboat.firstwebservice.entities.User;
import com.techboat.firstwebservice.exceptions.ElementConflict;
import com.techboat.firstwebservice.exceptions.NoElementFoundException;
import com.techboat.firstwebservice.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User addNewUser(User user) {
		Optional<User> exitUser = userRepo.findByName(user.getName());
		if (exitUser.isPresent())
			throw new ElementConflict(
					String.format("The User with the name [%s] exit please try another", user.getName()));
		return userRepo.save(user);

	}

	public User getUserByID(long id) {
		User user = userRepo.findById(id).orElseThrow(() -> new NoElementFoundException(
				String.format("The user with this id [%s] don't exists try another ID", id)));
		return user;

	}

	public User updateUser(long id, User user) {
		User userToUpdate = userRepo.findById(id).orElseThrow(() -> new ElementConflict(
				String.format("The User with the name [%s] exit please try another", user.getName())));
		userToUpdate.setName(user.getName());
		userToUpdate.setLasteName(user.getLasteName());
		userToUpdate.setDateBirth(user.getDateBirth());

		return userRepo.save(userToUpdate);

	}

	public void deleteUser(long id) {

		boolean exist = userRepo.existsById(id);
		if (!exist) {
			throw new NoElementFoundException(String.format("No user with the id [%s] was found in our database", id));
		} else {
			userRepo.deleteById(id);
		}
	}

}
