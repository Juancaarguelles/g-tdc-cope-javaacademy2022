package com.thesis;

import com.thesis.persistence.model.Message;
import com.thesis.persistence.model.User;
import com.thesis.services.MessageService;
import com.thesis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FinalThesisApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(FinalThesisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		this.populateData();
	}

	private void populateData()
	{
		User user1 = new User(100, "juanca", "1234", "Juan Camilo", "Arguelles Ardila", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		User user2 = new User(200, "juanda", "1234", "Juan David", "Ardila", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		User user3 = new User(300, "daniela", "1234", "Daniela", "Fonseca", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		User user4 = new User(400, "daniel", "1234", "Daniel", "Hernandez", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		User user5 = new User(500, "will", "1234", "William", "Mendoza", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		User user6 = new User(600, "monk", "1234", "Monica", "Bayuelo", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		User user7 = new User(700, "caste", "1234", "Diego", "Castellanos", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		User user8 = new User(800, "sergi", "1234", "Sergio", "Mesa", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		User user9 = new User(900, "ironman", "1234", "Anthony", "Stark", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		User user10 = new User(110, "spiderman", "1234", "Peter", "Parker", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");

		List<User>users = new ArrayList<>(Arrays.asList(user1,
				user2, user3, user4, user5, user6, user7, user8, user9, user10));

		users.forEach(this.userService::save);
	}
}
