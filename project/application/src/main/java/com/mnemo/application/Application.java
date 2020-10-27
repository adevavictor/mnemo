package com.mnemo.application;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mnemo.application.domain.Group;
import com.mnemo.application.domain.User;
import com.mnemo.application.repository.GroupRepository;
import com.mnemo.application.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final UserRepository userRepository;
	private final GroupRepository groupRepository;

	public Application(UserRepository userRepository, GroupRepository groupRepository) {
		this.userRepository = userRepository;
		this.groupRepository = groupRepository;
	}

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Group group1 = new Group();
		group1.setName("Group.1");
		
		Group group2 = new Group();
		group2.setName("Group.2");
		
		Group group3 = new Group();
		group3.setName("Group.3");
		
		groupRepository.saveAll(Arrays.asList(group1, group2, group3));
		
		User user1 = new User();
		user1.setName("User.1.Name");
		user1.setSurname("User.1.Surname");
		user1.setCode("User.1.code");
		user1.setGroups(Arrays.asList(group1));
		
		User user2 = new User();
		user2.setName("User.2.Name");
		user2.setSurname("User.2Surname");
		user2.setCode("User.2.code");
		user2.setGroups(Arrays.asList(group1, group2));
		
		User user3 = new User();
		user3.setName("User.3.Name");
		user3.setSurname("User.3Surname");
		user3.setCode("User.3.code");
		user3.setGroups(Arrays.asList(group1, group2, group3));
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
	}
}
