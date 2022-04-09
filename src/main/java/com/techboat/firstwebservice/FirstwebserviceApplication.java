package com.techboat.firstwebservice;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techboat.firstwebservice.entities.User;
import com.techboat.firstwebservice.repos.UserRepo;

@SpringBootApplication
public class FirstwebserviceApplication implements CommandLineRunner {
@Autowired
UserRepo userRepo;
	public static void main(String[] args) {
		SpringApplication.run(FirstwebserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 User user1= new User(null, "Slimani", "khaled",LocalDate.of(1989, 1, 28)); 
		 userRepo.save(user1);
		 User user2= new User(null, "Slimani", "bouleam",LocalDate.of(1990, 12, 11)); 
		 userRepo.save(user2);
		 User user3= new User(null, "Slimani", "nacer",LocalDate.of(2003, 6, 5)); 
		 userRepo.save(user3);
	}
	
	

}
