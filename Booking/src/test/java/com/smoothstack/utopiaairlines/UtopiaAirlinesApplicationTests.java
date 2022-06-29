package com.smoothstack.utopiaairlines;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Assert.*;
import com.smoothstack.utopiaairlines.controllers.BookingsController;

@SpringBootTest
class UtopiaAirlinesApplicationTests {
	
	@Autowired
	private BookingsController controller;
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
	
	@Test
	public void bookingHome() {

	}
}
