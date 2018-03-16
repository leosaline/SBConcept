package com.wroclaw.saline.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void whenSendLoginThenStartGame() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/newgame/leo");

		mockMvc.perform(requestBuilder).andExpect(new ResultMatcher() {
			@Override
			public void match(MvcResult result) throws Exception {
				assertNotNull(result.getResponse().getContentAsString());
			}
		});
	}
	
	@Test
	public void whenSendGameAndMoveThenReturnGameMoved() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/move");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		assertNotNull(result.getResponse().getContentAsString());
	}

}
