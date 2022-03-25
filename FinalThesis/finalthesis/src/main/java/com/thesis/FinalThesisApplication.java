package com.thesis;

import com.thesis.persistence.model.User;
import com.thesis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalThesisApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(FinalThesisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.populateData();
	}

	private void populateData()
	{
		User user1 = new User(100345, "juanca", "1234", "Juan Camilo", "Arguelles Ardila", "Cra 2 # 32 -49", "12345", "Boyaca", "Colombia");
		this.userService.save(user1);
	}
}
