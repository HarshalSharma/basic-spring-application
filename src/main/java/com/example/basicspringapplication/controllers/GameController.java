package com.example.basicspringapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicspringapplication.entities.Game;
import com.example.basicspringapplication.repositories.GameRepository;

@RestController
public class GameController {

	@Autowired
	GameRepository gameRepository;

	@GetMapping("/searchGameByTitle")
	public Page<Game> searchGamesByTitle(@RequestParam("title") String title, Pageable pageable) {
		return gameRepository.findByTitleContainingIgnoreCase(title, pageable);
	}

	@GetMapping("/listAllGames")
	public Page<Game> searchGames(Pageable pageable) {
		return gameRepository.findAll(pageable);
	}

	@PostMapping("/addNewGame")
	public ResponseEntity saveNewGame(@RequestBody Game game) {
		try {
			gameRepository.save(game);
			return new ResponseEntity(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@DeleteMapping
	public ResponseEntity deleteGame(@RequestParam("id") Integer gameId) {
		try {
			gameRepository.findById(gameId).ifPresent(game -> gameRepository.delete(game));
			return new ResponseEntity(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
