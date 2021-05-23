package com.example.SpringBootGoogleSSO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.security.Principal;

@SpringBootApplication
@RestController
@Slf4j
public class SpringBootGoogleSsoApplication {

	public static void main(String[] args) {
		log.info(String.format("Application executed"));
		SpringApplication.run(SpringBootGoogleSsoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		log.info(String.format("Application started"));
	}

	@GetMapping
	public String welcome() {
		return "Welcome to Google";
	}

	@GetMapping("/user")
	public Principal userPrincipal(Principal principal) {
		System.out.println(String.format("Username: %s", principal.getName()));
		return principal;
	}

}
