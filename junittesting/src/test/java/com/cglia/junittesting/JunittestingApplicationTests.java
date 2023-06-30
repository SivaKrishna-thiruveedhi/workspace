package com.cglia.junittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebAppConfiguration
@SpringBootTest
class JunittestingApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMVC;

	@BeforeEach
	private void setup() throws Exception {
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void testSave() throws Exception {
		String payload = "{ \"villageId\": 100, \"villageName\": \"Nand\", \"population\": 100000, \"status\": 1 }";
		mockMVC.perform(post("/village/v1/save").contentType(MediaType.APPLICATION_JSON).content(payload))
		.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testGetOneVillage() throws Exception {
		String payload = "{ \"villageId\": 101, \"villageName\": \"Nand\", \"population\": 100000, \"status\": 1 }";
		
		mockMVC.perform(post("/village/v1/save").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(status().isOk()).andReturn();
		
		mockMVC.perform(get("/village/v1/getone/{id}", 101)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testGetByVillageName() throws Exception {
		String payload = "{ \"villageId\": 100, \"villageName\": \"Nand\", \"population\": 100000, \"status\": 1 }";
		mockMVC.perform(post("/village/v1/save").contentType(MediaType.APPLICATION_JSON).content(payload))
			.andExpect(status().isOk()).andReturn();
		mockMVC.perform(get("/village/v1/getByName/{name}", "nand")).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testGetAllVillages() throws Exception {
		String payload = "{ \"villageId\": 100, \"villageName\": \"Nand\", \"population\": 100000, \"status\": 1 }";
		mockMVC.perform(post("/village/v1/save").contentType(MediaType.APPLICATION_JSON).content(payload))
			.andExpect(status().isOk()).andReturn();
		mockMVC.perform(get("/village/v1")).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testDeleteById() throws Exception {
		String payload = "{ \"villageId\": 100, \"villageName\": \"Nand\", \"population\": 100000, \"status\": 1 }";
		mockMVC.perform(post("/village/v1/save").contentType(MediaType.APPLICATION_JSON).content(payload))
			.andExpect(status().isOk()).andReturn();
		mockMVC.perform(delete("/village/v1/deleteById/{id}",100)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testUpdateById() throws Exception {
		String payload = "{ \"villageId\": 100, \"villageName\": \"Nand\", \"population\": 100000, \"status\": 1 }";
		mockMVC.perform(post("/village/v1/save").contentType(MediaType.APPLICATION_JSON).content(payload))
			.andExpect(status().isOk()).andReturn();
		ResultActions resultActions = mockMVC.perform(put("/village/v1/updateById/{id}", 100)
	            						.contentType(MediaType.APPLICATION_JSON)
	            						.content(payload));

	    resultActions.andExpect(status().isOk())
	            .andReturn();
	}
	
}























