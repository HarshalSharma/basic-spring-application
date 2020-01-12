package com.example.basicspringapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicspringapplication.entities.Game;
import com.example.basicspringapplication.repositories.GameRepository;

@RestController
public class GameController {

	@Autowired
	GameRepository repository;
	
	@GetMapping("/hello")
	public String basicController() {
		return "Hello World!";
	}
	
	
	@GetMapping("/searchGameByTitle")
	public List<Game> searchGames(@RequestParam("title") String title){
		return repository.findByTitleContaining(title);
	}
	
}
