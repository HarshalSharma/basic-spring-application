package com.example.basicspringapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

	@GetMapping("/hello")
	public String basicController() {
		return "Hello World!";
	}
	
}
