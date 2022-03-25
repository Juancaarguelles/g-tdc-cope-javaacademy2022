package com.thesis;

import com.thesis.persistence.model.Message;
import com.thesis.persistence.model.User;
import com.thesis.services.MessageService;
import com.thesis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

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
		User user1 = new User(100345, "juanca", "1234", "Juan Camilo", "Arguelles Ardila", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		//Message message1 = new Message("juanda", "juand", "janda", "esta es la prueba", "hola gente", "file.txt");
		//message1.setOrigin(user1.getUserName());
		//user1.addMessage(message1);
		this.userService.save(user1);

		User user2 = new User(100, "juanda", "1234", "Juan Camilo", "Arguelles Ardila", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		this.userService.save(user2);

		User user3 = new User(1020, "daniela", "1234", "Juan Camilo", "Arguelles Ardila", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		this.userService.save(user3);

		User user4 = new User(10201, "daniel", "1234", "Juan Camilo", "Arguelles Ardila", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		this.userService.save(user4);
	}
}
