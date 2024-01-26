package com.example.Project_3;


import com.example.Project_3.entities.users.User;
import com.example.Project_3.sevice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.OutputStream;
import java.util.Objects;

@SpringBootApplication
public class Project3Application {

	public static void main(String[] args) {
		SpringApplication.run(Project3Application.class , args);
	}

//	@Bean
//	CommandLineRunner run (UserService userService) {
//		return args -> {
//			userService.encoderPassword("user4");
//		};
//}
}
