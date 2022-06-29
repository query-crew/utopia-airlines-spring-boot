package com.smoothstack.utopiaairlines;


import org.springframework.boot.test.context.SpringBootTest;

import com.smoothstack.services.UserService;
import java.util.*;
import org.junit.jupiter.api.*;

@SpringBootTest
class UtopiaAirlinesApplicationTests {

	@Autowired
	UserService service;

	@Test
	void contextLoads() {
	}


	@Test
	void addUser(){
		Random rd = new Random();
		//generate a number between 1-100
		User user =  new User(rd.nextInt(100 - 1 + 1) + 1,"testUserName123", "test.email@smoothstack.com", "password", "users");
		service.addUser(user);
	}


	@Test
	void findUserById(){
		User user = new User(rd.nextInt(100 - 1 + 1) + 1,"testUserName123", "test.email@smoothstack.com", "password", "users");
		service.addUser(user);
		User userTwo = new User(rd.nextInt(100 - 1 + 1) + 1,"fakeUserName", "fake.email@smoothstack.com", "password", "users");
		service.addUser(userTwo);
	}
}
