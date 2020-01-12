package com.example.basicspringapplication.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.basicspringapplication.entities.Game;

@Repository
public interface GameRepository extends PagingAndSortingRepository<Game, Integer> {

	Page<Game> findByTitleContaining(String title, Pageable pageable);
	
}
