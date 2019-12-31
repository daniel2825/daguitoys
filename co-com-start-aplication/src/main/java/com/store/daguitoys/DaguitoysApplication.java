package com.store.daguitoys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={
		"co.com.inventory",
		"co.com.daguiModel.Models"})
public class DaguitoysApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaguitoysApplication.class, args);
	}

}
