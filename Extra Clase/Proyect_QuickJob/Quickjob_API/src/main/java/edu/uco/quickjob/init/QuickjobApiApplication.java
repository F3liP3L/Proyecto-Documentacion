package edu.uco.quickjob.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.uco.quickjob"})
public class QuickjobApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickjobApiApplication.class, args);
	}

}
