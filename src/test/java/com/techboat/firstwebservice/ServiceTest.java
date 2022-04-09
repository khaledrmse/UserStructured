package com.techboat.firstwebservice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.techboat.firstwebservice.entities.User;
import com.techboat.firstwebservice.exceptions.NoElementFoundException;
import com.techboat.firstwebservice.repos.UserRepo;
import com.techboat.firstwebservice.services.UserService;
import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ServiceTest {
	@MockBean
	UserRepo userRepo;
	@Autowired
	UserService userService;

	List<User> listusers;
	User u1, u2, u3, u4;

	@BeforeEach
	void intValue() {
		u1 = new User((long) 1, "slimani", "khaled", LocalDate.of(1989, 1, 28));
		u2 = new User((long) 2, "slimani", "nacer", LocalDate.of(2003, 6, 5));
		u3 = new User((long) 3, "saadi", "meriem", LocalDate.of(2012, 8, 28));
		u4 = new User((long) 4, "saadi", "abd arahmen", LocalDate.of(2014, 2, 28));
		listusers = Arrays.asList(u1, u2, u3, u4);
	}

	@Test
	public void whenGetAllUsersTest() {
		given(userRepo.findAll()).willReturn(listusers);
		assertThat(userService.getAllUsers()).hasSize(4);
		// other methode
		when(userRepo.findAll()).thenReturn(listusers);
		assertAll(() -> assertEquals(4, userService.getAllUsers().size()));

	}

	@Test
	public void whengetById() {
		when(userRepo.findById((long) 1)).thenReturn(Optional.ofNullable(u1));
		assertEquals("slimani", userService.getUserByID(1).getName());
	}

	@Test
	public void whengetByIdElmentNotFoundException() {
		when(userRepo.findById((long) 6)).thenThrow(new NoElementFoundException("no Element Found with this id"));
		assertThrows(NoElementFoundException.class, () -> userService.getUserByID((long) 6));
	}

}
