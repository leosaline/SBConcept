package com.wroclaw.saline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wroclaw.saline.entity.Game;
import com.wroclaw.saline.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public GameService() {
	}
	
	public GameService(GameRepository repository) {
		this.gameRepository = repository;
	}

	public Game startGame(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	public Game move(Game game) {
		// TODO Auto-generated method stub
		return null;
	}
}
