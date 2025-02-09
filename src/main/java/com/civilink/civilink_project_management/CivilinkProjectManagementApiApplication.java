package com.civilink.civilink_project_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class CivilinkProjectManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CivilinkProjectManagementApiApplication.class, args);
	}

}
