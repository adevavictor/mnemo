package com.mnemo.application.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mnemo.api.request.CreateUserRequest;
import com.mnemo.api.request.UpdateUserRequest;
import com.mnemo.api.request.dto.GroupRequestDto;
import com.mnemo.api.request.dto.UserRequestDto;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void getAll() throws Exception {
		// GET ALL
		this.mockMvc.perform(get("/users")).andExpect(status().isOk());
		
		// PASS PAGE
		this.mockMvc.perform(get("/users?page=0")).andExpect(status().isOk());
		
		// PASS ORDER
		this.mockMvc.perform(get("/users?order=asc")).andExpect(status().isOk());
		
		// PASS TYPE AND VALUE
		this.mockMvc.perform(get("/users?type=id&value=1")).andExpect(status().isOk());
		
		// WRONG TYPE
		this.mockMvc.perform(get("/users?type=idi&value=1")).andExpect(status().is4xxClientError());
		
		// WRONG VALUE, CORRECT TYPE
		this.mockMvc.perform(get("/users?type=idi&value=")).andExpect(status().is4xxClientError());
	}

	@Test
	public void getSingle() throws Exception {
		// EXISTS
		this.mockMvc.perform(get("/user/1")).andExpect(status().isOk());

		// NOT EXISTS
		this.mockMvc.perform(get("/user/10")).andExpect(status().is4xxClientError());

		// BAD REQUEST
		this.mockMvc.perform(get("/user/a")).andExpect(status().is4xxClientError());
	}

	@Test
	public void post() throws Exception {
		CreateUserRequest request = new CreateUserRequest();

		UserRequestDto userDto = new UserRequestDto();
		userDto.setName("User.Test.Name");
		userDto.setSurname("User.Test.Surame");
		userDto.setCode("USer.Test.COde");

		GroupRequestDto groupDto = new GroupRequestDto();
		groupDto.setId(Long.valueOf(3));
		groupDto.setName("Group.3");

		List<GroupRequestDto> groups = new ArrayList<GroupRequestDto>();
		groups.add(groupDto);

		userDto.setGroups(groups);

		request.setUser(userDto);

		// SAVE
		mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().is2xxSuccessful());

		// MODIFY CODE
		request.getUser().setCode("New.Code.User");
		mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().is2xxSuccessful());

		// SET INVALID VALUE
		request.getUser().setCode("");
		mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().is4xxClientError());
	}

	@Test
	public void patch() throws Exception {
		UpdateUserRequest request = new UpdateUserRequest();

		UserRequestDto userDto = new UserRequestDto();
		userDto.setName("User.Test.Name");
		userDto.setSurname("User.Test.Surame");
		userDto.setCode("USer.Test.COde.Mod");

		GroupRequestDto groupDto = new GroupRequestDto();
		groupDto.setId(Long.valueOf(3));
		groupDto.setName("Group.3");

		List<GroupRequestDto> groups = new ArrayList<GroupRequestDto>();
		groups.add(groupDto);

		userDto.setGroups(groups);

		request.setUser(userDto);

		// SAVE
		mockMvc.perform(MockMvcRequestBuilders.patch("/user/1").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().is2xxSuccessful());

		// SET INVALID VALUE
		request.getUser().setCode("");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/1").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().is4xxClientError());

		// NOT EXISTING
		request.getUser().setCode("");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/99").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))).andExpect(status().is4xxClientError());
	}

	@Test
	public void delete() throws Exception {
		// DELETE
		mockMvc.perform(MockMvcRequestBuilders.delete("/user/2")).andExpect(status().is2xxSuccessful());

		// NOT EXISTING
		mockMvc.perform(MockMvcRequestBuilders.delete("/user/4")).andExpect(status().is4xxClientError());
	}
}