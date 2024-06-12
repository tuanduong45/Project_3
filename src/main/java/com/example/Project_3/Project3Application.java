package com.example.Project_3;


import com.example.Project_3.entities.users.User;
import com.example.Project_3.sevice.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class Project3Application {

	public static void main(String[] args) {
		SpringApplication.run(Project3Application.class , args);

	}


}
