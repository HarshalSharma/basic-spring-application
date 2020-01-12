package com.example.basicspringapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Game> searchGames(@RequestParam("title") String title, Pageable pageable){
		return repository.findByTitleContaining(title, pageable);
	}
	
}
