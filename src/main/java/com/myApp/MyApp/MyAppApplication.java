package com.myApp.MyApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//@ComponentScan({"com.myApp.MyApp","com.myApp.MyApp.controller"})
@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}

}
