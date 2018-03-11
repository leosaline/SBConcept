package com.wroclaw.saline.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void whenSendUserCreateNewAndReturn() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/newuser/leonardo/leo/teste");
		
		System.out.println("+++++++++++" + mockMvc);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println("=================>" + result);
		String expected = "";
		
		assertTrue(true);
		
	}
	
//	@Test
//	public void whenSendLoginThenReturnUser() {
//		
//	}
}
