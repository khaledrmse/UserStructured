package com.techboat.firstwebservice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techboat.firstwebservice.entities.User;
import com.techboat.firstwebservice.services.UserService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class Controllertest {
  
	@Autowired
	MockMvc mockMvc;

	@MockBean
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
	public void whengetAllUsers() throws Exception {
		when(userService.getAllUsers()).thenReturn(listusers);
		mockMvc.perform(get("/api/users")).andExpect(status().isOk());
		// check
		mockMvc.perform(get("/api/users").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()) // check
																												// if
																												// the
																												// status																					// response
																												// is OK
				.andExpect(jsonPath("$", hasSize(4))) // check the size of the returned JSON Object
				.andExpect(jsonPath("$[0].name", equalTo(u1.getName()))); // check if the first element is with the name
																			// Slimani

	}
	@Test
	public void whensaveUser() throws Exception {
		ObjectMapper objectMapper =new ObjectMapper();
		objectMapper.writeValueAsString(u1.getDateBirth());
		when(userService.addNewUser(u1)).thenReturn(u1);
		mockMvc.perform(post("/api/users")
		.contentType(MediaType.APPLICATION_JSON)
		.content(objectMapper.writeValueAsString(u1))) // convert u1 to String JSon
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$.name", is(u1.getName())));
	}

}
