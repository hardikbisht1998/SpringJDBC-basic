package com.hardik.SpringJDBCDemo;

import com.hardik.SpringJDBCDemo.model.Alien;
import com.hardik.SpringJDBCDemo.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringJdbcDemoApplication.class, args);
		Alien alien=context.getBean(Alien.class);
		alien.setId(1);
		alien.setName("hardik");
		alien.setTech("Java");

		AlienRepo alienRepo=context.getBean(AlienRepo.class);
		alienRepo.save(alien);

		System.out.println(alienRepo.getAliens());

	}

}
