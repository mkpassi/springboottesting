package com.mkpassi.springboottesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloWorldBasicTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders
						.get("/hello-world")
						.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andReturn();
		assertEquals("Hello World", result.getResponse().getContentAsString());
	}

	@Test
	void helloWorldExpectTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
						.get("/hello-world")
						.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
						.andExpect(result -> assertEquals("Hello World", result.getResponse().getContentAsString()))
						.andExpect(status().isOk())
						//.andExpect(content().string("Hello World"))
						.andReturn();

	}
}
