package com.example.basicspringapplication.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.basicspringapplication.entities.Game;

@Repository
public interface GameRepository extends PagingAndSortingRepository<Game, Integer> {

	List<Game> findByTitleContaining(String title);
	
}
