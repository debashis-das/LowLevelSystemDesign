package com.systemdesign.lowLevelSystemDesign;

import com.systemdesign.lowLevelSystemDesign.SnakeAndLadder.SnakeAndLadderApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	static IApplication application;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		application = new SnakeAndLadderApplication();
		application.execute();
	}

}
